package com.vmorg;

import com.vmorg.machines.DesktopMachine;
import com.vmorg.machines.Machine;
import com.vmorg.machines.ServerMachine;

public class Application {
    public static void main(String[] args) {

        Machine desktopMachine = new DesktopMachine("some", "username", 11, "1omf", 2);
        Machine linuxMachine = new ServerMachine("somename", "user", 8, 16,
                "Ubuntu", 10, "Turner", "Some tema");

        System.out.println(desktopMachine);

    }
}