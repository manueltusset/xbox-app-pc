package com.tusset.utils;

import com.tusset.Main.Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 *
 * @author mtusset
 */
public class GamesUtil {

    public static HashMap<String, String> getGamesDesktop() {
        HashMap<String, String> games = new HashMap<>();
        try {
            final String pathGames = Util.getDirUser().concat("\\Desktop\\Games");
            final File fGames = new File(pathGames);

            if (!fGames.exists()) {
                return games;
            }

            for (File game : fGames.listFiles()) {
                String name = game.getName().substring(0, game.getName().length() - 4);
                String path = game.getAbsolutePath();
                games.put(name, path);
            }
        } catch (Exception ex) {
            Logger.getLogger(GamesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return games;
    }

    public static void populateGames(final Frame window) {
        HashMap<String, String> hashGames = getGamesDesktop();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthWindow = screenSize.getWidth();

        boolean verify = false;
        int x = 0;
        int y = 20;

        Set<String> games = hashGames.keySet();
        for (String game : games) {
            String pathGame = hashGames.get(game);

            System.out.println("Game: " + game);
            System.out.println("Path: " + pathGame);

            JButton btn = new JButton(game);
            btn.setBorder(null);
            btn.setBackground(new Color(2, 107, 14));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    btn.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    btn.setBorder(null);
                }
            });
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Util.execPowerShell("& '" + pathGame + "'");
                    } catch (Exception ex) {
                        Logger.getLogger(GamesUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            btn.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        try {
                            Util.execPowerShell("& '" + pathGame + "'");
                        } catch (Exception ex) {
                            Logger.getLogger(GamesUtil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });

            if (verify) {
                x += 190;

                if ((x + 190) >= (widthWindow - 190)) {
                    x = 0;
                    y = 210;
                }
            }
            btn.setBounds(x, y, 170, 170);
            verify = true;

            window.getPnlGames().add(btn);
        }
    }
}
