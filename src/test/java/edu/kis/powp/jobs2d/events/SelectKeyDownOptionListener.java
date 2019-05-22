package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

public class SelectKeyDownOptionListener implements ActionListener {

    private Button button;

    private DriverManager driverManager;

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public SelectKeyDownOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override public void actionPerformed(ActionEvent e) {
        logger.info("wejscie do metody");
        button = new Button();
        button.addKeyListener(new KeyAdapter() {
            @Override public void keyTyped(KeyEvent e) {
                logger.info("elo" + e.getKeyChar());
            }
        });

    }

}
