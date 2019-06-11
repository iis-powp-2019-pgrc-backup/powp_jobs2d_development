package edu.kis.powp.jobs2d.panel;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.MoveFeature;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class JPanelMouseControl {
    private static JPanel jPanel = null;

    public static JPanel getjPanel() {
        return jPanel;
    }

    private static DriverManager driverManager = null;

    public static void engage(JPanel jPanel, DriverManager driverManager)
    {
        setjPanel(jPanel);
        setDriverManager(driverManager);
        startListener();
    }

    private static void setjPanel(JPanel currentJPanel) {
        jPanel = currentJPanel;
    }


    private static void setDriverManager(DriverManager currentDriverManager) {
        driverManager = currentDriverManager;
    }


    private static void startListener() {
        jPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MoveFeature c2 = new MoveFeature();
                System.out.println("mouseClicked, X=" + e.getX() + " ,Y=" + e.getY() + " ,Count=" + e.getClickCount());
                c2.mouseevent(e.getX(),e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }

        });

        jPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                jPanel.setBounds(e.getX()-120, e.getY()-120, 500, 500);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }
}
