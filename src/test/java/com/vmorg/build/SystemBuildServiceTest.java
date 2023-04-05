package com.vmorg.build;

import com.vmorg.machines.Machine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.crypto.Mac;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SystemBuildServiceTest {

    @Mock
    SystemBuildService systemBuildService = mock(SystemBuildService.class);

    @Mock
    Machine successfulMachine = new Machine("mail-host");
    @Mock
    Machine failedMachine = new Machine();
    @BeforeEach
    void setUp() {
        when(systemBuildService.createNewMachine(successfulMachine)).thenReturn("host2023101231");
        when(systemBuildService.createNewMachine(failedMachine)).thenReturn("");
    }
    @Test
    void testCanCreateNewMachine() {
        String hostname = systemBuildService.createNewMachine(successfulMachine);

        assertFalse(hostname.isEmpty());
    }

    @Test
    void testCanNotCreateNewMachine(){
        String hostname = systemBuildService.createNewMachine(failedMachine);

        assertTrue(hostname.isEmpty());
    }
}