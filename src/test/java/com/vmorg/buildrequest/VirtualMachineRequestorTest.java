package com.vmorg.buildrequest;

import com.vmorg.exceptions.MachineNotCreatedException;
import com.vmorg.exceptions.UserNotEntitledException;
import com.vmorg.machines.Desktop;
import com.vmorg.machines.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class VirtualMachineRequestorTest {

    @Mock
    VirtualMachineRequestor requestor = mock(VirtualMachineRequestor.class);

    @Mock
    Desktop failedMachine;

    @Mock
    Server successfulMachine;


    @BeforeEach
    void setup() {
        //failed
    }

    @Test
    void testCanCreateNewRequest() {
        successfulMachine = mock(Server.class);
        failedMachine = mock(Desktop.class);
    }

    @Test
    void testThrowsUserNotEntitledExceptionOnNewMachineCreated() throws MachineNotCreatedException, UserNotEntitledException {
        doThrow(new UserNotEntitledException("User not entitled to create a machine"))
                .when(requestor).createNewRequest(failedMachine);

        assertThrows(UserNotEntitledException.class, requestor.createNewRequest(failedMachine));
    }

    @Test
    void totalBuildsByUserForDay() {
    }

    @Test
    void totalFailedBuildsForDay() {
    }
}