package com.tusset.Games;

import com.tusset.Main.Frame;
import com.tusset.utils.Util;
import static com.tusset.utils.Util.getDirUser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
        double widthWindow = (screenSize.getWidth() - 200);

        boolean verify = false;
        int x = 0;
        int y = 20;

        Set<String> games = hashGames.keySet();
        for (String game : games) {
            String pathGame = hashGames.get(game);

            if (verify) {
                x += 190;

                if ((x + 190) >= (widthWindow - 50)) {
                    x = 0;
                    if (y == 210) {
                        y = 400;
                    } else if (y == 400) {
                        y = 590;
                    } else {
                        y = 210;
                    }
                }
            }
            JButton btn = createButtonGame(game, pathGame, x, y, 170, 170);
            verify = true;
            window.getPnlGames().add(btn);
        }
    }

    public static void setPropertiesLastGame(final String game, final String pathGame) throws Exception {
        File fileProp = new File(getDirUser() + File.separator + "xbox-app-pc" + File.separator + "lastGame.properties");

        if (!fileProp.getParentFile().exists()) {
            fileProp.getParentFile().mkdir();
        }

        if (fileProp.exists()) {
            fileProp.delete();
        }

        try (OutputStream out = new FileOutputStream(fileProp)) {
            Properties prop = new Properties();
            prop.setProperty("game", game);
            prop.setProperty("path", pathGame);
            prop.store(out, null);
        } finally {
            System.out.println("Arquivo " + fileProp.getAbsolutePath() + " gravado com sucesso!");
        }
    }

    public static void populateLastGame(final Frame window) throws Exception {
        File fileProp = new File(getDirUser() + File.separator + "xbox-app-pc" + File.separator + "lastGame.properties");

        if (!fileProp.exists()) {
            return;
        }

        try (InputStream input = new FileInputStream(fileProp)) {
            Properties prop = new Properties();
            prop.load(input);
            final String game = prop.getProperty("game");
            final String path = prop.getProperty("path");
            JButton btnLastGame = createButtonGame(game, path, 10, 10, 300, 300);
            window.getPnlLastGame().add(btnLastGame);
        } finally {
            System.out.println("Leitura do arquivo properties realizada com sucesso!");
        }
    }

    public static JButton createButtonGame(final String game, final String pathGame, int x, int y, int width, int height) {
        JButton btn = new JButton(game);

        try {
            ImageIcon icon = Util.getImageGame(game);
            icon = Util.resizeImage(icon, width, height, Image.SCALE_SMOOTH);
            btn.setIcon(icon);
            btn.setText(null);
        } catch (Exception e) {
        }

        btn.setBorder(null);
        btn.setFocusPainted(false);
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
                    GamesUtil.setPropertiesLastGame(game, pathGame);
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
                        GamesUtil.setPropertiesLastGame(game, pathGame);
                    } catch (Exception ex) {
                        Logger.getLogger(GamesUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btn.setBounds(x, y, width, height);
        return btn;
    }
}
