package com.vmorg.exceptions;

public class UserNotEntitledException extends Exception{

    public UserNotEntitledException(String message){
        super(message);
    }

    public UserNotEntitledException(){
        super("User not entitled to create this  machine");
    }
}
