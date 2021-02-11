package com.tusset.utils.fun.template;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author mtusset
 */
public interface Fun {

    public void setCommand(final String command);

    public String getCommand();

    public void setCommandInfo(final String commandInfo);

    public String getCommandInfo();

    public void run() throws Exception;

    public String info() throws Exception;

    public ImageIcon image() throws Exception;

    public int imageWidth();

    public int imageHeight();

    public int imageScale();

    public String text();

    public Color background();
}
