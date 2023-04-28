package com.vmorg.buildrequest;

import com.vmorg.auth.AuthorisingService;
import com.vmorg.build.SystemBuildService;
import com.vmorg.exceptions.MachineNotCreatedException;
import com.vmorg.exceptions.UserNotEntitledException;
import com.vmorg.machines.DesktopMachine;
import com.vmorg.machines.Machine;
import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;

class VirtualMachineRequestorImplTest {
    //READ ON BEHAVIOR DRIVEN DEVELOPMENT given,when,then
    @Mock
    private AuthorisingService authorisingService;

    @Mock
    private SystemBuildService systemBuildService;

    private VirtualMachineRequestorImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new VirtualMachineRequestorImpl(authorisingService, systemBuildService);
    }

    @Test
    void shouldBuuildMachineSucessfully() throws MachineNotCreatedException, UserNotEntitledException {
        // given
        String user = "batman";
        String hostname = "host121321";
        Machine machine = new DesktopMachine(user, "user", 11, "2HS", 10);
        given(authorisingService.isAuthorised(user)).willReturn(true);
        given(systemBuildService.createNewMachine(machine)).willReturn(hostname);

        // when
        underTest.createNewRequest(machine);

        // then
        assertThat()
    }
}