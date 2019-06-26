package edu.kis.powp.jobs2d.panel;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.movment.MovmentManager;

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

                System.out.println("mouseClicked, X=" + e.getX() + " ,Y=" + e.getY() + " ,Width=" + jPanel.getWidth() + " ,Height=" +
                        jPanel.getHeight() + " ,Count=" + e.getClickCount());
               MovmentManager c1 = new MovmentManager();
                c1.mouseevent(e.getX(),e.getY(),jPanel.getWidth(),jPanel.getHeight() );
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

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }
}
