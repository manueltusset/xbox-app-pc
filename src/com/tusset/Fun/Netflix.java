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
 * @author mtusset
 */
public class Netflix extends Fun {

    private static final String COMMAND = "start netflix:";
    private static final String COMMAND_INFO = "Get-AppxPackage | where {$_.InstallLocation -ilike \"*netflix*\"}";
    private static final int WIDTH_IMAGE = 170;
    private static final int HEIGHT_IMAGE = 170;
    private static final int POSITION_X = 10;
    private static final int POSITION_Y = 20;
    private static final Border BORDER_FOCUS_GAINED = new MatteBorder(4, 4, 4, 4, new Color(183, 10, 19));
    private static final Border BORDER_FOCUS_LOST = null;

    public Netflix() {
        super(Netflix.COMMAND,
                Netflix.COMMAND_INFO,
                Netflix.WIDTH_IMAGE,
                Netflix.HEIGHT_IMAGE,
                Image.SCALE_SMOOTH,
                Netflix.POSITION_X,
                Netflix.POSITION_Y,
                null,
                Color.WHITE,
                Netflix.BORDER_FOCUS_GAINED,
                Netflix.BORDER_FOCUS_LOST);
    }

    @Override
    public String getInfo() throws Exception {
        return Util.execPowerShell(getCommandInfo());
    }

    @Override
    public ImageIcon getImage() throws Exception {
        URL imgUrl = Netflix.class.getResource("imgs/netflix.png");
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
