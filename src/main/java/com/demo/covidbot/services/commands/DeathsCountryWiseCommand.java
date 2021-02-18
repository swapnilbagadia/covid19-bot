package com.demo.covidbot.services.commands;

import com.demo.covidbot.apimodels.covid19api.Country;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.Optional;

/**
 * @author Swapnil Bagadia
 */

@Service("DeathsCountryWiseCommand")
public class DeathsCountryWiseCommand implements ICommand{


    @Autowired
    private RedisCommands<String, byte[]> redisCommands;

    @Override
    public String executeCommand(String[] command) {
        return Optional.ofNullable(redisCommands.get(command[1])).map(this::getValue).orElse("Country Not Found");
    }

    private String getValue(byte[] bytes) {
        Country country = (Country) SerializationUtils.deserialize(bytes);
        assert country != null;
        return country.getCountryCode() + " Deaths " + country.getTotalDeaths();
    }
}
