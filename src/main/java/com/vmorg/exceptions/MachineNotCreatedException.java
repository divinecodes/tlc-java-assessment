package com.vmorg.exceptions;

public class MachineNotCreatedException extends Exception{
    /**
     * throw a new MachineNotCreatedException
     */
    public MachineNotCreatedException(){
        super("Unable to create machine");
    }

    /**
     * throws a new MachineNotCreatedException with a custom message
     * @param message
     */
    public MachineNotCreatedException(String message){
        super(message);
    }
}
