package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Sets the next line to print as the string in input.
     */
    public void setNextPrint(String newstr);

    /**
     * Gets the next string the controller will send to print.
     * @return the next string to print.
     */
    public String getNextPrint();

    /**
     * Gets all the strings the controller printed.
     * @return a List containing all printed strings
     */
    public List<String> getPrintHistory();

    /**
     * Prints the next string.
     * @throws IllegalArgumentException if the next string to print is set as null.
     */
    public void printNext();



}
