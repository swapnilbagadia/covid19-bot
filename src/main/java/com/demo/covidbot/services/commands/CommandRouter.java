package com.demo.covidbot.services.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Swapnil Bagadia
 */

@Component
public class CommandRouter {

    @Autowired
    private ApplicationContext applicationContext;

    private final Map<String, String> commandBeanNameMap;

    CommandRouter() {
        commandBeanNameMap = new HashMap<>();
        commandBeanNameMap.put("CASES", ActiveCasesCountryWiseCommand.class.getSimpleName());
        commandBeanNameMap.put("DEATHS", DeathsCountryWiseCommand.class.getSimpleName());
        commandBeanNameMap.put("CASES TOTAL", TotalActiveCasesCommand.class.getSimpleName());
        commandBeanNameMap.put("DEATHS TOTAL", TotalDeathsCommand.class.getSimpleName());
    }

    public String executeCommand(String command) {
        String[] cmd = command.split(" ");
        if (cmd.length != 2) {
            throw new RuntimeException("Invalid Command ->" + command);
        }
        if (cmd[1].equals("TOTAL")) {
            return applicationContext.getBean(commandBeanNameMap.get(command), ICommand.class).executeCommand(cmd);
        } else {
            return applicationContext.getBean(commandBeanNameMap.get(cmd[0]), ICommand.class).executeCommand(cmd);
        }
    }
}
