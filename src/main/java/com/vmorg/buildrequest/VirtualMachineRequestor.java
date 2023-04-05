package com.vmorg.buildrequest;

import com.vmorg.exceptions.MachineNotCreatedException;
import com.vmorg.exceptions.UserNotEntitledException;
import com.vmorg.machines.Machine;

import java.util.Map;

/**
 * Interface used to create VM build requests.
 * VMs that are successfully created are tracked
 * for auditing on a daily basis, as are failed requests.
 * If the build is successful, add the machine
 * to the collection of machines built today.
 * If the build fails, record the failure for daily report.
 * The API can retrieve the total number of
 * successful build on a per-requestor basis (for cross-charging)
 * and the total number of all failed builds for a given day
 */
public interface VirtualMachineRequestor {

    /**
     * Checks user's entitlements, and if appropriate
     * creates a new request for a virtual machine build.
     * @param machine to be created, including hostname
     * and requestor fields
     * @param username of requestor
     * @throws UserNotEntitledException thrown
     * when a user is not entitled to make a request
     * @throws MachineNotCreatedException thrown
     * when a machine build is not successful
     */
    void createNewRequest(Machine machine,String username) throws UserNotEntitledException, MachineNotCreatedException;

    /**
     * Reports on the number of successful Windows
     * and Linux machine build requests on a per user basis
     * for today - for cross charging
     *
     * @return A map of users where the value is a map of
     * machine types -> quantity created
     */
    Map<String, Map<String, Integer>> totalBuildsByUserForDay();

    /**
     * Reports on the number of failed request builds
     * for today
     *
     * @return
     */
    int totalFailedBuildsForDay();
}
