package com.vmorg.buildrequest;

import com.vmorg.exceptions.MachineNotCreatedException;
import com.vmorg.exceptions.UserNotEntitledException;
import com.vmorg.machines.DesktopMachine;
import com.vmorg.machines.ServerMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class VirtualMachineRequestorTest {

    @Mock
    VirtualMachineRequestor requestor = mock(VirtualMachineRequestor.class);

    @Mock
    DesktopMachine failedMachine;

    @Mock
    ServerMachine successfulMachine;


    @BeforeEach
    void setup() {
        //failed
    }

    @Test
    void testCanCreateNewRequest() {
        successfulMachine = mock(ServerMachine.class);
        failedMachine = mock(DesktopMachine.class);
    }

    @Test
    void testThrowsUserNotEntitledExceptionOnNewMachineCreated() throws MachineNotCreatedException, UserNotEntitledException {
        doThrow(new UserNotEntitledException("User not entitled to create a machine"))
                .when(requestor).createNewRequest(failedMachine);

        //assertThrows(UserNotEntitledException.class, requestor.createNewRequest(failedMachine));
    }

    @Test
    void totalBuildsByUserForDay() {
    }

    @Test
    void totalFailedBuildsForDay() {
    }
}