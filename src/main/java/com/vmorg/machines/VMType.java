package com.vmorg.machines;

public enum VMType {
    ;
    private String name;
    DESKTOP("desktop"),
    SERVER("server");

    VMType(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }
}
