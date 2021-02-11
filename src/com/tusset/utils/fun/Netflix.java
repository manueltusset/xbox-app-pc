package com.tusset.utils.fun;

import com.tusset.utils.Util;
import com.tusset.utils.fun.template.Fun;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author mtusset
 */
public class Netflix implements Fun {

    private String command;
    private String commandInfo;

    public Netflix() {
        setCommand("start netflix:");
        setCommandInfo("Get-AppxPackage | where {$_.InstallLocation -ilike \"*netflix*\"}");
    }

    @Override
    public void setCommand(final String command) {
        this.command = command;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public void setCommandInfo(final String commandInfo) {
        this.commandInfo = commandInfo;
    }

    @Override
    public String getCommandInfo() {
        return this.commandInfo;
    }

    @Override
    public void run() throws Exception {
        Util.execPowerShell(getCommand());
    }

    @Override
    public String info() throws Exception {
        return Util.execPowerShell(getCommandInfo());
    }

    @Override
    public ImageIcon image() throws Exception {
        URL imgUrl = Netflix.class.getResource("imgs/netflix.png");
        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            icon = Util.resizeImage(icon, imageWidth(), imageHeight(), imageScale());
            return icon;
        }
        return null;
    }

    @Override
    public int imageWidth() {
        return 170;
    }

    @Override
    public int imageHeight() {
        return 100;
    }

    @Override
    public int imageScale() {
        return Image.SCALE_SMOOTH;
    }

    @Override
    public String text() {
        return null;
    }

    @Override
    public Color background() {
        return Color.WHITE;
    }
}
