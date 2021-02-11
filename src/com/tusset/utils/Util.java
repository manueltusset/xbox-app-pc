package com.tusset.utils;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

/**
 *
 * @author mtusset
 */
public class Util {

    public static String getDirUser() {
        return System.getProperty("user.home");
    }

    public static void execPowerShell(final String command) throws Exception {
        //Execute a command in PowerShell session
        PowerShellResponse response = PowerShell.executeSingleCommand(command);

        //Print results
        System.out.println("List Processes:" + response.getCommandOutput());
    }

}
