package de.fgtech.pomo4ka.AuthMe.util;

import de.fgtech.pomo4ka.AuthMe.MessageHandler.MessageHandler;
import de.fgtech.pomo4ka.AuthMe.Parameters.Settings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utility {

    public static File loadFileFromJar(String fileName) {
        File actual = new File(Settings.PLUGIN_FOLDER, fileName);
        if(!actual.exists()) {
            try(FileOutputStream output = new FileOutputStream(actual);
                    InputStream input = Utility.class.getResourceAsStream(
                            "/" + fileName);) {
                byte[] buf = new byte[8192];
                int length = 0;

                while((length = input.read(buf)) > 0) {
                    output.write(buf, 0, length);
                }
                MessageHandler.showInfo("File: " + fileName + " written");
            } catch(FileNotFoundException | IOException e) {
                MessageHandler.showStackTrace(e);
            }
        }
        return actual;
    }
}
