package de.fgtech.pomo4ka.AuthMe.util;

import de.fgtech.pomo4ka.AuthMe.MessageHandler.MessageHandler;
import de.fgtech.pomo4ka.AuthMe.Parameters.Settings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Utility {


    public static File loadFileFromJar(String fileName) {
        File actual = new File(Settings.PLUGIN_FOLDER, fileName);
        if(!actual.exists()) {
            InputStream input = Utility.class.getResourceAsStream("/" + fileName);
            if(input != null) {
                FileOutputStream output = null;
                try {
                    output = new FileOutputStream(actual);
                    byte[] buf = new byte[8192];
                    int length = 0;

                    while((length = input.read(buf)) > 0) {
                        output.write(buf, 0, length);
                    }

                    MessageHandler.showInfo("File: " + fileName +" written");
                } catch(Exception e) {
                    MessageHandler.showStackTrace(e);
                } finally {
                    try {
                        input.close();
                    } catch(Exception e) {
                    }
                    try {
                        output.close();
                    } catch(Exception e) {
                    }
                }
            }
        }
        return actual;
    }
}
