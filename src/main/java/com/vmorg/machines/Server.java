package com.vmorg.machines;

public class Server extends  Machine{
    private String distributionName;
    private int majorVersionNumber;
    private String kernelVersion;
    private String teamName;

    private static final int HARD_DISK_SIZE = 500;

    public final int CPU_SIZE_FOUR = 4;
    public final int CPU_SIZE_EIGHT = 8;
    public final int RAM_OPTION_ONE = 64;
    public final int RAM_OPTION_TWO  = 128;

    public Server() {

    }

    public Server(String identifier, String nameOfRequester, int numberOfCPU, int sizeOfRAM, String distributionName,
                  int majorVersionNumber, String kernelVersion, String teamName) {
        super(identifier, nameOfRequester, numberOfCPU, sizeOfRAM, HARD_DISK_SIZE,VMType.SERVER);
        this.distributionName = distributionName;
        this.majorVersionNumber = majorVersionNumber;
        this.kernelVersion = kernelVersion;
        this.teamName = teamName;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public int getMajorVersionNumber() {
        return majorVersionNumber;
    }

    public void setMajorVersionNumber(int majorVersionNumber) {
        this.majorVersionNumber = majorVersionNumber;
    }

    public String getKernelVersion() {
        return kernelVersion;
    }

    public void setKernelVersion(String kernelVersion) {
        this.kernelVersion = kernelVersion;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
