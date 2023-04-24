package com.vmorg.buildrequest;

import com.vmorg.auth.AuthorisingService;
import com.vmorg.build.SystemBuild;
import com.vmorg.build.SystemBuildService;
import com.vmorg.exceptions.MachineNotCreatedException;
import com.vmorg.exceptions.UserNotEntitledException;
import com.vmorg.machines.Machine;

import java.util.Map;

public class BuildRequest implements VirtualMachineRequestor {
    private static final int  MAX_MACHINES_PER_DAY = 999;
    private int totalFailedBuilds;

    private Map<String, Map<String, Integer>> totalUserBuilds;
    private Map<String,Integer> desktopBuilds;
    private Map<String, Integer> serverBuilds;

    private static int buildCount = 0;

    AuthorisingService authorisingService;
    SystemBuildService systemBuildService;

    public BuildRequest(AuthorisingService authorisingService, SystemBuildService systemBuildService){
        this.authorisingService = authorisingService;
        this.systemBuildService = systemBuildService;
    }

    /**
     *
     * @param machine to be created, including hostname and requestor fields
     * @throws UserNotEntitledException throws new user not entitled
     * @throws MachineNotCreatedException throws machine not created
     */
    @Override
    public void createNewRequest(Machine machine) throws UserNotEntitledException, MachineNotCreatedException {
        //check if user is entitled
        if(!authorisingService.isAuthorised(machine.getNameOfRequester())){
            throw new UserNotEntitledException(machine.getNameOfRequester()+ " not authorized");
        }


        //check if machine is not created due to limit
//        if((1 + buildCount) > MAX_MACHINES_PER_DAY){
//            throw new MachineNotCreatedException("Machine build exceeds total machines to be built today");
//        }


        if(systemBuildService.createNewMachine(machine).equals("")){
            ++totalFailedBuilds;
            throw new MachineNotCreatedException("Machine not created");
        }

        //totalUserBuilds.put();
        ++buildCount;
    }

    @Override
    public Map<String, Map<String, Integer>> totalBuildsByUserForDay() {
        return totalUserBuilds;
    }

    @Override
    public int totalFailedBuildsForDay() {
        return totalFailedBuilds;
    }

    public int getTotalFailedBuilds() {
        return totalFailedBuilds;
    }

    public void setTotalFailedBuilds(int totalFailedBuilds) {
        this.totalFailedBuilds = totalFailedBuilds;
    }

    public void updateBuilds(Machine machine){
//        if(machine.getVmType() == VMType.DESKTOP){
//            desktopBuilds.put("desktop")
//        }
    }

}