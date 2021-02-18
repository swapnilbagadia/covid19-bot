package com.demo.covidbot.controllers;

import com.demo.covidbot.apimodels.MessageCommand;
import com.demo.covidbot.constants.TwilioConstants;
import com.demo.covidbot.enums.WhatsappVendorEnum;
import com.demo.covidbot.services.WhatsappBotServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Swapnil Bagadia
 */

@RestController
@RequestMapping(value = "/v1/whatsapp")
public class WhatsappBotController {

    @Autowired
    private WhatsappBotServiceFactory whatsappBotServiceFactory;

    @PostMapping(value = "/twilio")
    public void postWhatsappIncomingMessage(@RequestParam Map<String, String> requestMap) {
        whatsappBotServiceFactory.getService(WhatsappVendorEnum.TWILIO).sendReply(new MessageCommand(requestMap.get(TwilioConstants.FROM_KEY), requestMap.get(TwilioConstants.BODY_KEY)));
    }

}
