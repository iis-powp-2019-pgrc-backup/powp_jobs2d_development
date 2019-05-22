package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

public class SelectKeyDownOptionListener extends JFrame implements KeyListener {

    private Button button;

    private DriverManager driverManager;

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public SelectKeyDownOptionListener() {
        setPreferredSize(new Dimension(300, 100));
        addKeyListener(this);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override public void keyTyped(KeyEvent e) {

    }

    @Override public void keyPressed(KeyEvent e) {

    }

    @Override public void keyReleased(KeyEvent e) {
        logger.info("key pressed " + e.getKeyChar());
    }
}
