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
public class MicrosoftStore extends Fun {

    private static final String COMMAND = "explorer.exe shell:appsFolder\\{PackageFamily}!App";
    private static final String COMMAND_INFO = "Get-AppxPackage | where {$_.InstallLocation -ilike \"*WindowsStore*\"} | findstr \"PackageFamilyName\"";
    private static final int WIDTH = 170;
    private static final int HEIGHT = 170;
    private static final int POSITION_X = 10;
    private static final int POSITION_Y = 10;
    private static final Border BORDER_FOCUS_GAINED = new MatteBorder(4, 4, 4, 4, Color.WHITE);
    private static final Border BORDER_FOCUS_LOST = null;

    public MicrosoftStore() {
        super(MicrosoftStore.COMMAND,
                MicrosoftStore.COMMAND_INFO,
                MicrosoftStore.WIDTH,
                MicrosoftStore.HEIGHT,
                Image.SCALE_SMOOTH,
                MicrosoftStore.POSITION_X,
                MicrosoftStore.POSITION_Y,
                null,
                Color.WHITE,
                MicrosoftStore.BORDER_FOCUS_GAINED,
                MicrosoftStore.BORDER_FOCUS_LOST);
    }

    @Override
    public String getInfo() throws Exception {
        return Util.execPowerShell(getCommandInfo());
    }

    @Override
    public ImageIcon getImage() throws Exception {
        URL imgUrl = MicrosoftStore.class.getResource("imgs/store.png");
        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            icon = Util.resizeImage(icon, getWidth(), getHeight(), getImageScale());
            return icon;
        }
        return null;
    }

    @Override
    public void run() throws Exception {
        final String packageStorePW = getInfo();

        if (packageStorePW != null && packageStorePW.contains("Microsoft.WindowsStore")) {
            final String packageStore = getCommand().replace("{PackageFamily}", packageStorePW.replace("PackageFamilyName : ", ""));
            Util.execPowerShell(packageStore);
        }
    }

}
