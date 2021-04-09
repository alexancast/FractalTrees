import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;
import java.awt.*;

public class Program extends JFrame {

    public Program() {

        setSize(800, Toolkit.getDefaultToolkit().getScreenSize().height);

        FractalDisplay display = new FractalDisplay();
        add(display, BorderLayout.CENTER);

        FractalControlPanel controlPanel = new FractalControlPanel(display);
        controlPanel.setPreferredSize(new Dimension(250, getHeight()));
        add(controlPanel, BorderLayout.EAST);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Program();
    }

}