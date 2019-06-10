package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.letters.AbstractFactory;
import edu.kis.powp.jobs2d.command.letters.ComplexCommand;
import edu.kis.powp.jobs2d.command.letters.LetterFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

public class KeyDownListener extends JFrame implements KeyListener {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private DriverManager driverManager;

    private KeyDownListener(DriverManager driverManager) {
        this.driverManager = driverManager;
        setPreferredSize(new Dimension(500, 100));
        setVisible(true);
        setTitle("Focus on this window and write a letter");
        pack();
        addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        DrawerFeature.getDrawerController().clearPanel();
        AbstractFactory letterFactory = new LetterFactory(driverManager);
        ComplexCommand complexCommand = (ComplexCommand) letterFactory.create(String.valueOf(evt.getKeyChar()));
        complexCommand.execute();
        logger.info("Released Key: " + evt.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }

    public static KeyDownListener getInstance(DriverManager driverManager) {
        return new KeyDownListener(driverManager);
    }

}
