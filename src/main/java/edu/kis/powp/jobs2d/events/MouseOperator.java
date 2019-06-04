package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

public class MouseOperator implements MouseListener {

    private JPanel jPanel;
    private DriverManager driverManager;
    protected final Logger logger = Logger.getLogger(getClass().getName());

    public MouseOperator(JPanel jPanel, DriverManager driverManager) {
        this.jPanel = jPanel;
        this.driverManager = driverManager;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent mouseEvent) {
        int widthOfPanel=jPanel.getWidth()/2;
        int heightOfPanel = jPanel.getHeight()/2;

        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            driverManager.getCurrentDriver().operateTo(mouseEvent.getX() - widthOfPanel,
                    mouseEvent.getY() - heightOfPanel);
            logger.warning("Operate to X:" + (mouseEvent.getX() - widthOfPanel) + " Y:" + (mouseEvent.getY() - heightOfPanel));
        } else if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            driverManager.getCurrentDriver().setPosition(mouseEvent.getX() - widthOfPanel,
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
