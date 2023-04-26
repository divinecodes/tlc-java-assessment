package com.vmorg;

import com.vmorg.machines.Desktop;
import com.vmorg.machines.Machine;
import com.vmorg.machines.Server;

public class Application {
    public static void main(String[] args) {

        Machine desktopMachine = new Desktop("some", "username", 11, "1omf", 2);
        Machine linuxMachine = new Server("somename", "user", 8, 16,
                "Ubuntu", 10, "Turner", "Some tema");

        System.out.println(desktopMachine);

    }
}