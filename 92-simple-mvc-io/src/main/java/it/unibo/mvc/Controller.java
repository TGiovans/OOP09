package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.channels.FileLockInterruptionException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currFile;

    public Controller() {
        this.currFile = new File(System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt");
    }

    public void setFile(File file) {
        if(file.exists()) {
            this.currFile = file;
        } else {
            throw new IllegalArgumentException("No file sent.");
        }
    }

    public File getFile() {
        return this.currFile;
    }

    public String getPath() {
        return this.currFile.getAbsolutePath();
    }

    public void writeOnFile(String str) throws FileNotFoundException {
        PrintStream out = new PrintStream(currFile);
        out.print(str);
        out.close();
    }
}
