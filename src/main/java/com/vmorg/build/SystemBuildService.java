package com.vmorg.build;

import com.vmorg.machines.Machine;

public interface SystemBuildService {

    /**
     * @param machine the machine to create
     * @return hostname , empty if machine was not created successfully
     */
    String createNewMachine(Machine machine);
}