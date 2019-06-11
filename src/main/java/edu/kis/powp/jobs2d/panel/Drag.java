package edu.kis.powp.jobs2d.panel;

import edu.kis.powp.jobs2d.features.DrawerFeature;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Drag {
    public Drag() {
        DrawerFeature.getDrawerController().clearPanel();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Img-move");
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JLayeredPane {

        public TestPane() {

            /*
            *
            * File absolute path finder on Windows
            *
            * */
            String filename = "src\\main\\java\\edu\\kis\\powp\\jobs2d\\panel\\images";
            String workingDirectory = System.getProperty("user.dir");

            String absoluteFilePath = "";
            absoluteFilePath = workingDirectory + File.separator + filename;

            //****************//

            File[] images = new File(absoluteFilePath).listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    String name = pathname.getName().toLowerCase();
                    return name.endsWith(".png") ||
                            name.endsWith(".jpg") ||
                            name.endsWith(".bmp") ||
                            name.endsWith(".jpeg") ||
                            name.endsWith(".gif");
                }
            });

            int x = 0;
            int y = 0;
            for (File imgFile : images) {

                try {
                    BufferedImage img = ImageIO.read(imgFile);
                    JLabel label = new JLabel(new ImageIcon(img));
                    label.setSize(label.getPreferredSize());
                    label.setLocation(x, y);
                    MouseHandler mh  = new MouseHandler();
                    label.addMouseListener(mh);
                    label.addMouseMotionListener(mh);
                    add(label);
                    x += 20;
                    y += 20;
                } catch (IOException exp) {
                    exp.printStackTrace();
                }

            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 800);
        }

        public class MouseHandler extends MouseAdapter {

            private Point offset;

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel label = (JLabel) e.getComponent();
                moveToFront(label);
                offset = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getPoint().x - offset.x;
                int y = e.getPoint().y - offset.y;
                Component component = e.getComponent();
                Point location = component.getLocation();
                location.x += x;
                location.y += y;
                component.setLocation(location);
            }

        }

    }

}