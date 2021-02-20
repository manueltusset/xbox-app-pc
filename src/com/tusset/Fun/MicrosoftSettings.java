package com.tusset.Fun;

import com.tusset.Fun.template.Fun;
import com.tusset.utils.Util;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author manue
 */
public class MicrosoftSettings extends Fun {

    private static final String COMMAND = "start ms-settings:";
    private static final String COMMAND_INFO = "Get-AppxPackage | where {$_.InstallLocation -ilike \"*ms-settings*\"}";
    private static final int WIDTH_IMAGE = 170;
    private static final int HEIGHT_IMAGE = 170;
    private static final int POSITION_X = 200;
    private static final int POSITION_Y = 10;
    private static final Border BORDER_FOCUS_GAINED = new MatteBorder(4, 4, 4, 4, Color.WHITE);
    private static final Border BORDER_FOCUS_LOST = null;

    public MicrosoftSettings() {
        super(MicrosoftSettings.COMMAND,
                MicrosoftSettings.COMMAND_INFO,
                MicrosoftSettings.WIDTH_IMAGE,
                MicrosoftSettings.HEIGHT_IMAGE,
                Image.SCALE_SMOOTH,
                MicrosoftSettings.POSITION_X,
                MicrosoftSettings.POSITION_Y,
                null,
                Color.WHITE,
                MicrosoftSettings.BORDER_FOCUS_GAINED,
                MicrosoftSettings.BORDER_FOCUS_LOST);
    }

    @Override
    public String getInfo() throws Exception {
        return Util.execPowerShell(getCommandInfo());
    }

    @Override
    public ImageIcon getImage() throws Exception {
        URL imgUrl = MicrosoftSettings.class.getResource("imgs/settings.png");
        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            icon = Util.resizeImage(icon, getWidth(), getHeight(), getImageScale());
            return icon;
        }
        return null;
    }

    @Override
    public void run() throws Exception {
        Util.execPowerShell(getCommand());
    }

}
