package com.tusset.Fun.util;

import com.tusset.Fun.AmazonPrimeVideo;
import com.tusset.Fun.MicrosoftSettings;
import com.tusset.Fun.MicrosoftStore;
import com.tusset.Fun.Netflix;
import com.tusset.Fun.template.Fun;
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

/**
 *
 * @author mtusset
 */
public class FunUtil {

    public static void populateFun(final Frame window) throws Exception {
        final JButton netflixFun = createFun(new Netflix());
        window.getPnlFun().add(netflixFun);

        final JButton amazonPrimeFun = createFun(new AmazonPrimeVideo());
        window.getPnlFun().add(amazonPrimeFun);

        final JButton microsoftStore = createFun(new MicrosoftStore());
        window.getPnlAdic().add(microsoftStore);

        final JButton microsoftSettings = createFun(new MicrosoftSettings());
        window.getPnlAdic().add(microsoftSettings);
    }

    private static JButton createFun(final Fun fun) throws Exception {
        JButton btn = new JButton();
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setIcon(fun.getImage());
        btn.setText(fun.getText());
        btn.setBackground(fun.getBackground());
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                btn.setBorder(fun.getBorderFocusGained());
            }

            @Override
            public void focusLost(FocusEvent e) {
                btn.setBorder(fun.getBorderFocusLost());
            }
        });
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fun.run();
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
                        fun.run();
                    } catch (Exception ex) {
                        Logger.getLogger(FunUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btn.setBounds(fun.getPositionX(),
                fun.getPositionY(),
                fun.getWidth(),
                fun.getHeight());

        return btn;
    }

}
