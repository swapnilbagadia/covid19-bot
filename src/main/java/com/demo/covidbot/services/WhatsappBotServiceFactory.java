package com.demo.covidbot.services;

import com.demo.covidbot.enums.WhatsappVendorEnum;
import com.demo.covidbot.services.impl.TwilioWhatsappBotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Swapnil Bagadia
 */

@Component
public class WhatsappBotServiceFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public IWhatsappBotService getService(WhatsappVendorEnum vendorEnum) {
        switch (vendorEnum) {
            case TWILIO:
                return getBean(TwilioWhatsappBotServiceImpl.class.getSimpleName());
            default:
                return getBean(TwilioWhatsappBotServiceImpl.class.getSimpleName());
        }
    }

    private IWhatsappBotService getBean(String beanName) {
        return applicationContext.getBean(beanName, IWhatsappBotService.class);
    }

}
