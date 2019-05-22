package edu.kis.powp.jobs2d.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

public class KeyDownListener implements KeyListener {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        logger.info("Released Key: " + evt.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent evt) {

    }

}
