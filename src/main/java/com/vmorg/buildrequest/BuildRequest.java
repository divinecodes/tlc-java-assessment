package com.vmorg.buildrequest;

import com.vmorg.auth.Authorisation;
import com.vmorg.auth.AuthorisingService;
import com.vmorg.build.SystemBuild;
import com.vmorg.build.SystemBuildService;
import com.vmorg.exceptions.MachineNotCreatedException;
import com.vmorg.exceptions.UserNotEntitledException;
import com.vmorg.machines.Machine;
import com.vmorg.machines.VMType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildRequest implements VirtualMachineRequestor {


    private static final int  MAX_MACHINES_PER_DAY = 999;
    private int totalFailedBuilds;

    private Map<String, Map<String, Integer>> totalUserBuilds;
    private Map<String,Integer> desktopBuilds;
    private Map<String, Integer> serverBuilds;

    private static int buildCount = 0;


    @Override
    public void createNewRequest(Machine machine, String username) throws UserNotEntitledException, MachineNotCreatedException {
        //check if user is entitled
        Authorisation authorisation = new Authorisation();
        if(!authorisation.isAuthorised(username)){
            throw new UserNotEntitledException(username+ " not authorized");
        }


        //check if machine is not created due to limit
        if((1 + buildCount) > MAX_MACHINES_PER_DAY){
            throw new MachineNotCreatedException("Machine build exceeds total machines to be built today");
        }

        SystemBuild build = new SystemBuild();
        if(build.createNewMachine(machine).isEmpty()){ //machine build failed
            ++totalFailedBuilds;
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
