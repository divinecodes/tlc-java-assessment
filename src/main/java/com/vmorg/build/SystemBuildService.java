package com.vmorg.build;

import com.vmorg.machines.Machine;

public interface SystemBuildService {

    /**
     * create a new machine
     *
     * @param machine
     * @return
     */
    String createNewMachine(Machine machine);
}
