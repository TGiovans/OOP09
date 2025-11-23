package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller ctrl;

    /**
     * Creates a simple interface with buttons to show print history and print lines.
     */
    public SimpleGUI() {
        ctrl = new SimpleController();
        final JPanel mainPanel = new JPanel();
        final JPanel bottomPanel = new JPanel();
        final JTextField printText = new JTextField();
        final JTextArea logText = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");
        mainPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout());
        mainPanel.add(printText, BorderLayout.NORTH);
        mainPanel.add(logText, BorderLayout.CENTER);
        bottomPanel.add(print, BorderLayout.WEST);
        bottomPanel.add(showHistory, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                ctrl.setNextPrint(printText.getText());
                ctrl.printNext();
            }
        });
        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                logText.setText(ctrl.getPrintHistory().toString());
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Runs the program, creating and displaying the GUI implemented in this class.
     * 
     * @param args - whatever is passed in input.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
