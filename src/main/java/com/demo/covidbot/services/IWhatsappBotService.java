package com.demo.covidbot.services;

import com.demo.covidbot.apimodels.MessageCommand;

/**
 * @author Swapnil Bagadia
 */

public interface IWhatsappBotService {

    void sendReply(MessageCommand command);

}
