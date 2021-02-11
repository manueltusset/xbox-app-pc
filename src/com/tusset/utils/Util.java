package com.tusset.utils;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;
import com.tusset.utils.games.GamesUtil;
import java.awt.Image;
import java.net.URL;
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

    public static String normalizeName(String game) {
        game = game.toLowerCase().replace(" ", "");
        game = game.replaceAll("[^0-9A-Za-z]", "");
        return game;
    }

    public static ImageIcon getImageGame(String game) {
        game = normalizeName(game);
        URL imgURL;
        imgURL = GamesUtil.class.getResource("imgs/" + game + ".jpg");
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            return null;
        }
    }

    public static ImageIcon resizeImage(ImageIcon icon, int width, int height, int scale) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, scale);
        icon = new ImageIcon(newImg);
        return icon;
    }
}
