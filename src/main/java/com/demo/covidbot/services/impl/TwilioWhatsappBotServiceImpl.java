package com.demo.covidbot.services.impl;

import com.demo.covidbot.apimodels.MessageCommand;
import com.demo.covidbot.services.IWhatsappBotService;
import com.demo.covidbot.services.commands.ActiveCasesCountryWiseCommand;
import com.demo.covidbot.services.commands.CommandRouter;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Swapnil Bagadia
 */

@Service("TwilioWhatsappBotServiceImpl")
public class TwilioWhatsappBotServiceImpl implements IWhatsappBotService {

    @Autowired
    private ActiveCasesCountryWiseCommand activeCasesCountryWiseCommand;

    @Autowired
    private CommandRouter commandRouter;

    @Override
    public void sendReply(MessageCommand command) {
        Message.creator(
                new com.twilio.type.PhoneNumber(command.getToNumber()),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                commandRouter.executeCommand(command.getMessage()))
                .create();
    }
}
