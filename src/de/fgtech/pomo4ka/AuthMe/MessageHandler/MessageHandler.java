package de.fgtech.pomo4ka.AuthMe.MessageHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageHandler {

    public static final Logger l = Logger.getLogger("Minecraft");

    public static void showInfo(String message) {
        l.log(Level.INFO, "[AuthMe] " + message);
    }

    public static void showError(String message) {
        l.log(Level.SEVERE, "[AuthMe] " + message);
    }

    public static void showWarning(String message) {
        l.log(Level.WARNING, "[AuthMe] " + message);
    }

    public static void showStackTrace(Throwable t) {
        l.log(Level.SEVERE, t.getMessage(), t);
    }
}
