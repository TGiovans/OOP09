package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> log;
    private String nextToPrint;

    /**
     * Created a simple controller to handle stdout.
     */
    public SimpleController() {
        this.log = new LinkedList<>();
        nextToPrint = null;
    }

    @Override
    public void setNextPrint(final String newstr) {
        this.nextToPrint = newstr;
    }

    @Override
    public String getNextPrint() {
        return this.nextToPrint;
    }

    @Override
    public List<String> getPrintHistory() {
        final List<String> ret = new LinkedList<>();
        ret.addAll(this.log);
        return ret;
    }

    @Override
    public void printNext() {
        if (this.nextToPrint == null) {
            throw new IllegalArgumentException("No string to print.");
        }
        System.out.println(this.nextToPrint); // NOPMD requested by the exercise
        this.log.add(this.nextToPrint);
        this.nextToPrint = null;
    }

}
