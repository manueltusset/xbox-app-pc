package com.tusset.utils;

import com.tusset.utils.games.GamesUtil;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        Process p = Runtime.getRuntime().exec("powershell -Command \"" + command.replace("\"", "\\\"") + "\"");
        final String result = readResultRuntime(p);
        System.out.println(result);
        return result;
    }

    private static String readResultRuntime(Process p) throws Exception {
        BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        String s = null;
        StringBuilder sb = new StringBuilder();
        while ((s = err.readLine()) != null) {
            sb.append("\n").append(s);
        }

        if (!toStringSB(sb).isEmpty()) {
            throw new Exception(toStringSB(sb));
        }

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        sb = new StringBuilder();
        s = null;
        while ((s = stdInput.readLine()) != null) {
            sb.append("\n").append(s);
        }
        return toStringSB(sb);
    }

    private static String toStringSB(StringBuilder sb) {
        return sb.toString().replaceFirst("\n", "");
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
