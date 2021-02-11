package com.tusset.Main;

import com.tusset.utils.ControllerUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Controller;

/**
 *
 * @author mtusset
 */
public class Start {

    private Frame window;
    private Controller controller;

    public Start() {
        window = new Frame();
        window.setVisible(true);

        if (ControllerUtil.checkControllersConnected(window)) {
            controller = ControllerUtil.getController();
            threadActions();
        }
    }

    public void threadActions() {
        while (true) {
            if (!controller.poll()) {
                break;
            }

            ControllerUtil.getActionController(controller, window);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}
