package com.vmorg.machines;

import java.time.LocalDate;

public abstract class Machine {
    private String identifier;
    private String nameOfRequester;
    private int numberOfCPUs;
    private int sizeOfRAM;
    private int sizeOfDisk;
    private VMType vmType;

    public Machine() {

    }

    public Machine(String identifier, String nameOfRequester, int numberOfCPU, int sizeOfRAM, int sizeOfDisk,VMType vmType){
        this.identifier = identifier;
        this.nameOfRequester = nameOfRequester;
        this.sizeOfDisk = sizeOfDisk;
        this.sizeOfRAM = sizeOfRAM;
        this.numberOfCPUs = numberOfCPU;
        this.vmType = vmType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNameOfRequester() {
        return nameOfRequester;
    }

    public void setNameOfRequester(String nameOfRequester) {
        this.nameOfRequester = nameOfRequester;
    }

    public int getNumberOfCPUs() {
        return numberOfCPUs;
    }

    public void setNumberOfCPUs(int numberOfCPUs) {
        this.numberOfCPUs = numberOfCPUs;
    }

    public int getSizeOfRAM() {
        return sizeOfRAM;
    }

    public void setSizeOfRAM(int sizeOfRAM) {
        this.sizeOfRAM = sizeOfRAM;
    }

    public int getSizeOfDisk() {
        return sizeOfDisk;
    }

    public void setSizeOfDisk(int sizeOfDisk) {
        this.sizeOfDisk = sizeOfDisk;
    }

    /**
     * generate hostname
     *
     * @param buildRequestNumber
     * @return
     */
    public String generateHostName(int buildRequestNumber){
        LocalDate today = LocalDate.now();
        //add prefix to build number;
        String hostname = "host"+today.toString().replace("-","");
        if( buildRequestNumber > 10 && buildRequestNumber < 100){
            hostname += "0"+buildRequestNumber;
        } else if (buildRequestNumber < 10){
            hostname += "=00"+buildRequestNumber;
        }
        return hostname;
    }
}
