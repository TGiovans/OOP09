package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Sets the next line to print as the string in input.
     * 
     * @param newstr - string to set as next to print.
     */
    void setNextPrint(String newstr);

    /**
     * Gets the next string the controller will send to print.
     * 
     * @return the next string to print.
     */
    String getNextPrint();

    /**
     * Gets all the strings the controller printed.
     * 
     * @return a List containing all printed strings
     */
    List<String> getPrintHistory();

    /**
     * Prints the next string.
     * 
     * @throws IllegalArgumentException if the next string to print is set as null.
     */
    void printNext();

}
