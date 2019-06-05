package edu.kis.powp.jobs2d.eventListener;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.features.RecorderFeature;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyMouseDrawingListener implements MouseListener {
    private Application app;

    public MyMouseDrawingListener(Application app) {
        this.app = app;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        DriverCommand commandToRecord = null;
        int x = e.getX() - app.getFreePanel().getWidth() / 2;
        int y = e.getY() - app.getFreePanel().getHeight() / 2;

        if (e.getButton() == MouseEvent.BUTTON1) {
            commandToRecord = new OperateToCommand(x, y);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            commandToRecord = new SetPositionCommand(x, y);
        }

        if(commandToRecord != null) {
            commandToRecord.execute(DriverFeature.getDriverManager().getCurrentDriver());
            RecorderFeature.record(commandToRecord);
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
