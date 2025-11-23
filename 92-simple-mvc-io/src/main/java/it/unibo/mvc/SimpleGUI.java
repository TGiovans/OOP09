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
import java.io.File;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller ctrl;

    /**
     * Creates a simple GUI to interact with.
     */
    public SimpleGUI() {
        ctrl = new Controller();
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea empty = new JTextArea();
        mainPanel.add(empty, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        mainPanel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final File toSave = new File(empty.getText());
                ctrl.setFile(toSave);
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
         * Starts the GUI.
         * 
         * @param args - whatever is passed in input at launch.
         */
        public static void main(final String[] args) {
        new SimpleGUI().display();
        new SimpleGUIWithFileChooser().display();
    }

}
