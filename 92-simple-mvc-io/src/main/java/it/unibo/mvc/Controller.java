package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currFile;

    /**
     * Creates a controller which can manage I/O.
     */
    public Controller() {
        this.currFile = new File(System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt");
    }

    /**
     * Sets the file in use to the one in input.
     * 
     * @param file - the file the controller should look at now.
     */
    public void setFile(final File file) {
        if (file.exists()) {
            this.currFile = file;
        } else {
            throw new IllegalArgumentException("No file sent.");
        }
    }

    /**
     * Gets the file the controller is storing right now.
     * 
     * @return the file the controller is interacting with.
     */
    public File getFile() {
        return this.currFile;
    }

    /**
     * Gets the path of the file the controller is managing.
     * 
     * @return the absolute path of the file the controller is managing as String.
     */
    public String getPath() {
        return this.currFile.getAbsolutePath();
    }

    /**
     * Writes the given string on the stored file.
     * 
     * @param str - the string to write in the file
     * @throws IOException if an I/O error occurs when accessing file.
     */
    public void writeOnFile(final String str) throws IOException {
        final PrintStream out = new PrintStream(currFile, StandardCharsets.UTF_8);
        out.print(str);
        out.close();
    }
}
