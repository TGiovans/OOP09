package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final Controller dealer = new Controller();
    private final JFrame frame = new JFrame();

    /**
     * Creates a simple GUI with integrated file chooser.
     */
    public SimpleGUIWithFileChooser() {
        final JTextField fileChooser = new JTextField();
        final JPanel fileChoicePanel = new JPanel();
        final JButton filePress = new JButton("Browse");
        final JPanel mainPanel = new JPanel();
        final JTextArea empty = new JTextArea();
        final JButton save = new JButton("Save");
        fileChoicePanel.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        fileChooser.setEditable(false);
        fileChooser.setText(dealer.getPath());
        filePress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent a) {
                final JFileChooser browser = new JFileChooser();
                switch (browser.showSaveDialog(null)) {
                    case JFileChooser.APPROVE_OPTION: dealer.setFile(browser.getSelectedFile()); 
                                                      fileChooser.setText(dealer.getPath());
                                                      break;
                    case JFileChooser.CANCEL_OPTION: break;
                    default: JOptionPane.showMessageDialog(null, 
                                                "Apologies, an error has occurred.", 
                                                  "ERROR", 
                                                        JOptionPane.ERROR_MESSAGE); 
                }
            }
        });
        fileChoicePanel.add(fileChooser, BorderLayout.CENTER);
        fileChoicePanel.add(filePress, BorderLayout.EAST);
        mainPanel.add(empty, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        mainPanel.add(fileChoicePanel, BorderLayout.NORTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Displays the GUI on screen.
     */
    void display() {
            final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int sw = (int) screen.getWidth();
            final int sh = (int) screen.getHeight();
            frame.setSize(sw / PROPORTION, sh / PROPORTION);
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        }

}
