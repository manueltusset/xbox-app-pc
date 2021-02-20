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
public class AmazonPrimeVideo extends Fun {

    private static final String COMMAND = "start primevideo:";
    private static final String COMMAND_INFO = "Get-AppxPackage | where {$_.InstallLocation -ilike \"*primevideo*\"}";
    private static final int WIDTH_IMAGE = 170;
    private static final int HEIGHT_IMAGE = 170;
    private static final int POSITION_X = 10;
    private static final int POSITION_Y = 210;
    private static final Border BORDER_FOCUS_GAINED = new MatteBorder(4, 4, 4, 4, new Color(0, 170, 225));
    private static final Border BORDER_FOCUS_LOST = null;

    public AmazonPrimeVideo() {
        super(AmazonPrimeVideo.COMMAND,
                AmazonPrimeVideo.COMMAND_INFO,
                AmazonPrimeVideo.WIDTH_IMAGE,
                AmazonPrimeVideo.HEIGHT_IMAGE,
                Image.SCALE_SMOOTH,
                AmazonPrimeVideo.POSITION_X,
                AmazonPrimeVideo.POSITION_Y,
                null,
                Color.WHITE,
                AmazonPrimeVideo.BORDER_FOCUS_GAINED,
                AmazonPrimeVideo.BORDER_FOCUS_LOST);
    }

    @Override
    public String getInfo() throws Exception {
        return Util.execPowerShell(getCommandInfo());
    }

    @Override
    public ImageIcon getImage() throws Exception {
        URL imgUrl = AmazonPrimeVideo.class.getResource("imgs/prime-video.png");
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
