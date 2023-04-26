package com.vmorg.build;

import com.vmorg.machines.Machine;
import com.vmorg.machines.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SystemBuildServiceTest {

    @Mock
    SystemBuildService systemBuildService = mock(SystemBuildService.class);

    @Mock
    Machine successfulMachine;
    @Mock
    Machine failedMachine;

    @BeforeEach
    void setUp() {
        successfulMachine = mock(Server.class);

        when(systemBuildService.createNewMachine(successfulMachine)).thenReturn("host12321321");
        when(systemBuildService.createNewMachine(failedMachine)).thenReturn("");
    }

    @Test
    void testCanCreateNewMachine() {
        String hostname = systemBuildService.createNewMachine(successfulMachine);

        assertFalse(hostname.isEmpty());
    }

    @Test
    void testCanNotCreateNewMachine() {
        String hostname = systemBuildService.createNewMachine(failedMachine);

        assertTrue(hostname.isEmpty());
    }
}