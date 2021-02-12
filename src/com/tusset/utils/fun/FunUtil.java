package com.tusset.utils.fun;

import com.tusset.Main.Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

/**
 *
 * @author mtusset
 */
public class FunUtil {

    public static void populateFun(final Frame window) throws Exception {
        final JButton netflixFun = createNetflixFun();
        window.getPnlFun().add(netflixFun);

        final JButton amazonPrimeFun = createAmazonPrimeFun();
        window.getPnlFun().add(amazonPrimeFun);

        final JButton microsoftStore = createStoreFun();
        window.getPnlAdic().add(microsoftStore);

        final JButton microsoftSettings = createConfigFun();
        window.getPnlAdic().add(microsoftSettings);
    }

    private static JButton createNetflixFun() throws Exception {
        Netflix netflix = new Netflix();

        JButton btn = new JButton();
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setIcon(netflix.image());
        btn.setText(netflix.text());
        btn.setBackground(netflix.background());
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                btn.setBorder(new MatteBorder(4, 4, 4, 4, new Color(183, 10, 19)));
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
                    netflix.run();
                } catch (Exception ex) {
                    Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
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
                        netflix.run();
                    } catch (Exception ex) {
                        Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btn.setBounds(10, 20, 170, 170);

        return btn;
    }

    private static JButton createAmazonPrimeFun() throws Exception {
        AmazonPrimeVideo amazonPrimeVideo = new AmazonPrimeVideo();

        JButton btn = new JButton();
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setIcon(amazonPrimeVideo.image());
        btn.setText(amazonPrimeVideo.text());
        btn.setBackground(amazonPrimeVideo.background());
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                btn.setBorder(new MatteBorder(4, 4, 4, 4, new Color(0, 170, 225)));
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
                    amazonPrimeVideo.run();
                } catch (Exception ex) {
                    Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
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
                        amazonPrimeVideo.run();
                    } catch (Exception ex) {
                        Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btn.setBounds(10, 210, 170, 170);

        return btn;
    }

    private static JButton createStoreFun() throws Exception {
        MicrosoftStore store = new MicrosoftStore();

        JButton btn = new JButton();
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setIcon(store.image());
        btn.setText(store.text());
        btn.setBackground(store.background());
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
                    store.run();
                } catch (Exception ex) {
                    Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
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
                        store.run();
                    } catch (Exception ex) {
                        Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btn.setBounds(10, 10, 170, 170);

        return btn;
    }

    private static JButton createConfigFun() throws Exception {
        MicrosoftSettings settings = new MicrosoftSettings();

        JButton btn = new JButton();
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setIcon(settings.image());
        btn.setText(settings.text());
        btn.setBackground(settings.background());
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
                    settings.run();
                } catch (Exception ex) {
                    Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
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
                        settings.run();
                    } catch (Exception ex) {
                        Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btn.setBounds(200, 10, 170, 170);
        return btn;
    }

    private static JButton createArchivementsFun() throws Exception {
        return null;
    }
}
