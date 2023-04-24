package com.vmorg.build;

import com.vmorg.machines.Machine;

public class SystemBuild implements SystemBuildService{

    @Override
    public String createNewMachine(Machine machine) {
        //randomly build machines if a number is even
        int build = (int) (Math.random() * 10);
        if(build % 2 == 1){
            return machine.getHostname();
        }

        return "";
    }
}