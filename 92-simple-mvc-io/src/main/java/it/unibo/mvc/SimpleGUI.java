package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unibo.mvc.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    private final Controller ctrl;

    public SimpleGUI(){
        ctrl = new Controller();
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JTextArea empty = new JTextArea();
        mainPanel.add(empty, BorderLayout.CENTER);
        JButton save = new JButton("Save");
        mainPanel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent a) {
                ctrl.setFile(ctrl.getFile());
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
        
    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
