package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.appbase.Application;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

public class MouseEvents implements MouseListener {

    private Application application;
    protected final Logger logger = Logger.getLogger(getClass().getName());

    public MouseEvents(Application application) {
        this.application = application;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent mouseEvent) {
        int widthOfPanel=application.getFreePanel().getWidth()/2;
        int heightOfPanel = application.getFreePanel().getHeight()/2;

        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            DriverFeature.getDriverManager().getCurrentDriver().operateTo(mouseEvent.getX() - widthOfPanel,
                    mouseEvent.getY() - heightOfPanel);
            logger.warning("Operate to X:" + (mouseEvent.getX() - widthOfPanel) + " Y:" + (mouseEvent.getY() - heightOfPanel));
        } else if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            DriverFeature.getDriverManager().getCurrentDriver().setPosition(mouseEvent.getX() - widthOfPanel,
                    mouseEvent.getY() - heightOfPanel);
            logger.warning("Set Position X:" + (mouseEvent.getX() - widthOfPanel ) + " Y:" + (mouseEvent.getY() - heightOfPanel));
        }

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }
}
