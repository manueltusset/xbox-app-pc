package com.tusset.utils;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author mtusset
 */
public class Util {

    public static String getDirUser() {
        return System.getProperty("user.home");
    }

    public static String execPowerShell(final String command) throws Exception {
        PowerShellResponse response = PowerShell.executeSingleCommand(command);
        System.out.println("List Processes:" + response.getCommandOutput());
        return response.getCommandOutput();
    }

    public static ImageIcon resizeImage(ImageIcon icon, int width, int height, int scale) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, scale);
        icon = new ImageIcon(newImg);
        return icon;
    }
}
