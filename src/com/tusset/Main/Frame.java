package com.tusset.Main;

import com.tusset.template.Actions;
import com.tusset.utils.Util;
import com.tusset.utils.fun.FunUtil;
import com.tusset.utils.games.GamesUtil;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mtusset
 */
public class Frame extends javax.swing.JFrame {

    public Frame() throws Exception {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setImages();
        //createButtonA();
        GamesUtil.populateGames(this);
        GamesUtil.populateLastGame(this);
        FunUtil.populateFun(this);
    }

    private void setImages() {
        ImageIcon icon = createImageIcon("imgs/xbox.png");

        if (icon != null) {
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImg);
            lblImage.setIcon(icon);
            lblImage.setText(null);
        }
        Image back = new ImageIcon("imgs/background.jpg").getImage();
        if (back != null) {
            Graphics g = pnlGeral.getGraphics();
            g.drawImage(back, 0, 0, null);
            pnlGames.paint(g);
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL;
        imgURL = Frame.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            return null;
        }
    }

    private void createButtonA() {

        JPanel panelA = new JPanel();
        panelA.setBackground(new Color(20, 20, 20));
        panelA.setBounds(0, 0, 50, pnlButtons.getHeight());

        JLabel btnA = new JLabel();
        ImageIcon A_Icon = createImageIcon("imgs/A.png");
        A_Icon = Util.resizeImage(A_Icon, 32, 32, Image.SCALE_SMOOTH);
        btnA.setIcon(A_Icon);
        btnA.setBounds(0, 0, 32, 32);

        panelA.add(btnA);

        JLabel labelA = new JLabel();
        labelA.setText("Open");
        labelA.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelA.setBounds(100, 0, 10, 10);
        labelA.setForeground(Color.WHITE);

        panelA.add(labelA);

        this.pnlButtons.add(panelA);
    }

    public void setAction(Actions.Action action) {
        switch (action) {
            case UP:
            case LEFT:
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                break;
            case DOWN:
            case RIGHT:
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                break;
            case OK:
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                break;
            case RETURN:
                break;
        }
    }

    public JLabel getLblDevice() {
        return lblDevice;
    }

    public void setLblDevice(JLabel lblDevice) {
        this.lblDevice = lblDevice;
    }

    public JPanel getPnlGames() {
        return pnlGames;
    }

    public void setPnlFun(JPanel pnlFun) {
        this.pnlFun = pnlFun;
    }

    public JPanel getPnlFun() {
        return pnlFun;
    }

    public void setPnlGames(JPanel pnlGames) {
        this.pnlGames = pnlGames;
    }

    public JPanel getPnlLastGame() {
        return pnlLastGame;
    }

    public void setPnlLastGame(JPanel pnlLastGame) {
        this.pnlLastGame = pnlLastGame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeral = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        pnlGames = new javax.swing.JPanel();
        lblDevice = new javax.swing.JLabel();
        pnlFun = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        pnlLastGame = new javax.swing.JPanel();
        pnlButtons = new javax.swing.JPanel();
        btnA = new javax.swing.JLabel();
        labelA = new javax.swing.JLabel();
        btnB = new javax.swing.JLabel();
        labelB = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        btnY = new javax.swing.JLabel();
        btnX = new javax.swing.JLabel();
        labelX = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Xbox PC - Manuel Tusset");
        setBackground(new java.awt.Color(20, 20, 20));
        setForeground(java.awt.Color.lightGray);
        setUndecorated(true);

        pnlGeral.setBackground(new java.awt.Color(20, 20, 20));

        pnlGames.setBackground(new java.awt.Color(20, 20, 20));

        javax.swing.GroupLayout pnlGamesLayout = new javax.swing.GroupLayout(pnlGames);
        pnlGames.setLayout(pnlGamesLayout);
        pnlGamesLayout.setHorizontalGroup(
            pnlGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGamesLayout.setVerticalGroup(
            pnlGamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblDevice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblDevice.setForeground(new java.awt.Color(255, 255, 255));
        lblDevice.setText("Device Connected:");

        pnlFun.setBackground(new java.awt.Color(20, 20, 20));

        javax.swing.GroupLayout pnlFunLayout = new javax.swing.GroupLayout(pnlFun);
        pnlFun.setLayout(pnlFunLayout);
        pnlFunLayout.setHorizontalGroup(
            pnlFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        pnlFunLayout.setVerticalGroup(
            pnlFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Seja Bem-Vindo, Manuel!");

        pnlLastGame.setBackground(new java.awt.Color(20, 20, 20));

        javax.swing.GroupLayout pnlLastGameLayout = new javax.swing.GroupLayout(pnlLastGame);
        pnlLastGame.setLayout(pnlLastGameLayout);
        pnlLastGameLayout.setHorizontalGroup(
            pnlLastGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        pnlLastGameLayout.setVerticalGroup(
            pnlLastGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        pnlButtons.setBackground(new java.awt.Color(20, 20, 20));

        btnA.setIcon(Util.resizeImage(new ImageIcon(Frame.class.getResource("imgs/A.png")), 32, 32, Image.SCALE_SMOOTH));

        labelA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelA.setForeground(new java.awt.Color(255, 255, 255));
        labelA.setText("  Open");

        btnB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnB.setIcon(Util.resizeImage(new ImageIcon(Frame.class.getResource("imgs/B.png")), 32, 32, Image.SCALE_SMOOTH));

        labelB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelB.setForeground(new java.awt.Color(255, 255, 255));
        labelB.setText(" Exit");

        labelY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelY.setForeground(new java.awt.Color(255, 255, 255));
        labelY.setText("All Games");

        btnY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnY.setIcon(Util.resizeImage(new ImageIcon(Frame.class.getResource("imgs/Y.png")), 32, 32, Image.SCALE_SMOOTH));

        btnX.setIcon(Util.resizeImage(new ImageIcon(Frame.class.getResource("imgs/X.png")), 32, 32, Image.SCALE_SMOOTH));

        labelX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelX.setForeground(new java.awt.Color(255, 255, 255));
        labelX.setText("Xbox App");

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelX)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addComponent(pnlLastGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGeralLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblDevice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 950, Short.MAX_VALUE)
                                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeralLayout.createSequentialGroup()
                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeralLayout.createSequentialGroup()
                                .addComponent(pnlFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlGames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(pnlLastGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDevice)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnA;
    private javax.swing.JLabel btnB;
    private javax.swing.JLabel btnX;
    private javax.swing.JLabel btnY;
    private javax.swing.JLabel labelA;
    private javax.swing.JLabel labelB;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JLabel lblDevice;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlFun;
    private javax.swing.JPanel pnlGames;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlLastGame;
    // End of variables declaration//GEN-END:variables
}
