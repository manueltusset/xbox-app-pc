package com.tusset.Fun.template;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author mtusset
 */
public abstract class Fun {

    private String command;
    private String commandInfo;
    private int width = 170;
    private int height = 170;
    private int imageScale = Image.SCALE_SMOOTH;
    private int positionX;
    private int positionY;
    private String text = null;
    private Color background;
    private Border borderFocusGained;
    private Border borderFocusLost;

    public Fun(String command, String commandInfo, int imageWidth, int imageHeight, int imageScale,
            int positionX, int positionY, String text, Color background, Border borderFocusGained, Border borderFocusLost) {
        this.command = command;
        this.commandInfo = commandInfo;
        this.width = imageWidth;
        this.height = imageHeight;
        this.imageScale = imageScale;
        this.positionX = positionX;
        this.positionY = positionY;
        this.text = text;
        this.background = background;
        this.borderFocusGained = borderFocusGained;
        this.borderFocusLost = borderFocusLost;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getImageScale() {
        return imageScale;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getText() {
        return text;
    }

    public Color getBackground() {
        return background;
    }

    public String getCommand() {
        return command;
    }

    public String getCommandInfo() {
        return commandInfo;
    }

    public Border getBorderFocusGained() {
        return borderFocusGained;
    }

    public Border getBorderFocusLost() {
        return borderFocusLost;
    }

    public abstract String getInfo() throws Exception;

    public abstract ImageIcon getImage() throws Exception;

    public abstract void run() throws Exception;
}
