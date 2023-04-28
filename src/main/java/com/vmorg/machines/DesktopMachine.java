package com.vmorg.machines;

public class DesktopMachine extends Machine {
    private int windowsBuildVersion;
    private String buildNumber;

    private static final int RAM_SIZE = 16;
    private static final int HARD_DISK_SIZE = 160;

    public final int CPU_SIZE_ONE = 1;
    public final int CPU_SIZE_TWO = 2;

    public DesktopMachine(String identifier, String nameOfRequester, int windowsBuildVersion, String buildNumber, int cpuSize) {
        super(identifier, nameOfRequester, cpuSize, RAM_SIZE, HARD_DISK_SIZE);

        this.buildNumber = buildNumber;
        this.windowsBuildVersion = windowsBuildVersion;

    }

    public int getWindowsBuildVersion() {
        return windowsBuildVersion;
    }

    public void setWindowsBuildVersion(int windowsBuildVersion) {
        this.windowsBuildVersion = windowsBuildVersion;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public int getRAM_SIZE() {
        return RAM_SIZE;
    }

    public int getHARD_DISK_SIZE() {
        return HARD_DISK_SIZE;
    }
}