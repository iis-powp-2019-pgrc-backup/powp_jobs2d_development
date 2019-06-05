package edu.kis.powp.jobs2d.eventListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseDrawingListener implements MouseListener {
    private JPanel freePanel;
    private DriverManager driverManager;


    public MyMouseDrawingListener(JPanel jPanel, DriverManager driverManager) {
        this.freePanel = jPanel;
        this.driverManager = driverManager;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            driverManager.getCurrentDriver()
                    .operateTo(e.getX() - freePanel.getWidth() / 2, e.getY() - freePanel.getHeight() / 2);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            driverManager.getCurrentDriver()
                    .setPosition(e.getX() - freePanel.getWidth() / 2, e.getY() - freePanel.getHeight() / 2);

        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
