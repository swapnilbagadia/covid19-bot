package com.demo.covidbot.apimodels;

/**
 * @author Swapnil Bagadia
 */

public class MessageCommand {

    private String toNumber;
    private String message;

    public MessageCommand(String toNumber, String message) {
        this.toNumber = toNumber;
        this.message = message;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
