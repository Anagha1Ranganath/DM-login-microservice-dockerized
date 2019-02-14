package com.stackroute.deliverymanager.exception;

public class UserNameOrPasswordEmpty extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public UserNameOrPasswordEmpty()
    {}

    public UserNameOrPasswordEmpty(String message)
    {
        this.message=message;
    }
}
