package edu.kis.powp.jobs2d.events;

import edu.kis.powp.appbase.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class SelectKeyPrinterOptionListener implements ActionListener {

    private Application application;

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public SelectKeyPrinterOptionListener(Application application) {
        this.application = application;
    }

    @Override public void actionPerformed(ActionEvent e) {
        logger.info("Chosed key printer.");
        KeyDownListener.getInstance();
    }
}
