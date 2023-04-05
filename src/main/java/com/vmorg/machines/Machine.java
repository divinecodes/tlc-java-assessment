package com.vmorg.machines;

public class Machine {
    private String identifier;
    public Machine() {

    }

    public Machine(String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
