package com.tusset.utils.controller;

import com.tusset.Main.Frame;
import com.tusset.template.Actions;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

/**
 *
 * @author mtusset
 */
public class ControllerUtil {

    public static Controller getController() {
        final Controller[] retController = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for (Controller controller : retController) {
            if (controller.getType() == Controller.Type.STICK
                    || controller.getType() == Controller.Type.GAMEPAD
                    || controller.getType() == Controller.Type.WHEEL
                    || controller.getType() == Controller.Type.FINGERSTICK) {
                if (controller.poll()) {
                    return controller;
                }
            }
        }
        return null;
    }

    public static void getActionController(Controller controller, final Frame window) {
        Component[] components = controller.getComponents();
        for (int i = 0; i < components.length; i++) {
            Component component = components[i];
            Component.Identifier componentIdentifier = component.getIdentifier();

            if (componentIdentifier.getName().matches("^[0-9]*$")) {
                if (component.getPollData() == 0.0f) {
                    continue; //nao clicou nao retorna
                }

                switch (componentIdentifier.getName()) {
                    case "0":
                        window.setAction(Actions.Action.BUTTON_A);
                        break;
                    case "1":
                        window.setAction(Actions.Action.BUTTON_B);
                        break;
                    case "2":
                        window.setAction(Actions.Action.BUTTON_X);
                        break;
                    case "3":
                        window.setAction(Actions.Action.BUTTON_Y);
                        break;
                    case "6":
                        window.setAction(Actions.Action.BUTTON_MENU_ESQ);
                        break;
                    case "7":
                        window.setAction(Actions.Action.BUTTON_MENU_DIR);
                        break;
                }
                continue;
            } else if (componentIdentifier == Component.Identifier.Axis.POV) {
                float hatSwitchPosition = component.getPollData();

                switch (String.valueOf(hatSwitchPosition)) {
                    case "1.0":
                        window.setAction(Actions.Action.SWITCH_LEFT);
                        break;
                    case "0.5":
                        window.setAction(Actions.Action.SWITCH_RIGHT);
                        break;
                    case "0.75":
                        window.setAction(Actions.Action.SWITCH_DOWN);
                        break;
                    case "0.25":
                        window.setAction(Actions.Action.SWITCH_UP);
                        break;
                }
                continue;
            }
        }
    }

    public static boolean checkControllersConnected(final Frame window) {
        Controller controller = ControllerUtil.getController();
        if (controller == null) {
            window.getLblDevice().setText("No device connected");
            return false;
        } else {
            window.getLblDevice().setText("Device Connected: " + controller.getName());
        }
        return true;
    }
}
