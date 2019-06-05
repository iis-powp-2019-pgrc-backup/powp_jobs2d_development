package edu.kis.powp.jobs2d.eventListener;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseDrawingListener implements MouseListener {
    private Application app;


    public MyMouseDrawingListener(Application app) {
        this.app = app;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            DriverFeature.getDriverManager().getCurrentDriver()
                    .operateTo(e.getX() - app.getFreePanel().getWidth() / 2, e.getY() - app.getFreePanel().getHeight() / 2);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            DriverFeature.getDriverManager().getCurrentDriver()
                    .setPosition(e.getX() - app.getFreePanel().getWidth() / 2, e.getY() - app.getFreePanel().getHeight() / 2);

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
