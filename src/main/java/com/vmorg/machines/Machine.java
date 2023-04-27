package com.vmorg.machines;

import java.time.LocalDate;

public abstract class Machine {
    private final String hostname;
    private final String nameOfRequester;
    private final  int numberOfCPUs;
    private final int sizeOfRAM;
    private final int sizeOfDisk;

    public Machine(String hostname, String nameOfRequester, int numberOfCPU, int sizeOfRAM, int sizeOfDisk) {
        this.hostname = hostname;
        this.nameOfRequester = nameOfRequester;
        this.sizeOfDisk = sizeOfDisk;
        this.sizeOfRAM = sizeOfRAM;
        this.numberOfCPUs = numberOfCPU;
    }

    public String getHostname() {
        return hostname;
    }

    public String getNameOfRequester() {
        return nameOfRequester;
    }

    public int getNumberOfCPUs() {
        return numberOfCPUs;
    }

    public int getSizeOfRAM() {
        return sizeOfRAM;
    }

    public int getSizeOfDisk() {
        return sizeOfDisk;
    }

    @Override
    public String toString() {
        return "Machine";
    }
}