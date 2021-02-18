package com.demo.covidbot.services.commands;

import com.demo.covidbot.constants.Covid19ApiConstants;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.Optional;

/**
 * @author Swapnil Bagadia
 */

@Service("TotalActiveCasesCommand")
public class TotalActiveCasesCommand implements ICommand {

    @Autowired
    private RedisCommands<String, byte[]> redisCommands;

    @Override
    public String executeCommand(String[] command) {
        return Optional.ofNullable(redisCommands.get(Covid19ApiConstants.TOTAL_ACTIVE_CASES_KEY)).map(this::getValue).orElse("Data Unavailable");
    }

    private String getValue(byte[] bytes) {
        Long totalCases = (Long) SerializationUtils.deserialize(bytes);
        return "Total Active Cases " + totalCases;
    }
}
