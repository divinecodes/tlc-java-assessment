package com.vmorg.buildrequest;

import com.vmorg.auth.AuthorisingService;
import com.vmorg.build.SystemBuildService;
import com.vmorg.exceptions.MachineNotCreatedException;
import com.vmorg.exceptions.UserNotEntitledException;
import com.vmorg.machines.Machine;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class VirtualMachineRequestorImpl implements VirtualMachineRequestor {
    private static final int MAX_MACHINES_PER_DAY = 999;
    private int totalFailedBuilds;

    private Map<String, Map<String, Integer>> totalUserBuilds;

    private final List<Machine> successfulBuilds;
    private final List<Machine> failedBuilds;


    AuthorisingService authorisingService;
    SystemBuildService systemBuildService;

    public VirtualMachineRequestorImpl(AuthorisingService authorisingService, SystemBuildService systemBuildService) {
        this.authorisingService = authorisingService;
        this.systemBuildService = systemBuildService;

        this.successfulBuilds = new LinkedList<>();
        this.failedBuilds = new LinkedList<>();
    }


    /**
     * @param machine to be created, including hostname and requestor fields
     * @throws UserNotEntitledException   throws new user not entitled
     * @throws MachineNotCreatedException throws machine not created
     */
    @Override
    public void createNewRequest(Machine machine) throws UserNotEntitledException, MachineNotCreatedException {
        //check if user is entitled
        if (!authorisingService.isAuthorised(machine.getNameOfRequester())) {
            throw new UserNotEntitledException(machine.getNameOfRequester() + " not authorized");
        }


        if (systemBuildService.createNewMachine(machine).equals("")) {
            failedBuilds.add(machine);
            throw new MachineNotCreatedException("Machine not created");
        }

        successfulBuilds.add(machine);
        //totalUserBuilds.put();
    }

    @Override
    public Map<String, Map<String, Integer>> totalBuildsByUserForDay() {
        return totalUserBuilds;
    }

    @Override
    public int totalFailedBuildsForDay() {
        return this.failedBuilds.size();
    }

    List<Machine> getSuccessfulBuilds() {
        return this.successfulBuilds;
    }

    public int getTotalFailedBuilds() {
        return totalFailedBuilds;
    }

    public List<Machine> getFailedBuilds() {
        return failedBuilds;
    }
}