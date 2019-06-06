package edu.kis.powp.jobs2d.features;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.kis.powp.appbase.Application;

public class MouseDrawingFeature {
	public static void addMouseDrawing(Application app, Logger logger) {
		JPanel panel = app.getFreePanel();
		int width, height;
		width = panel.getWidth();
		height = panel.getHeight();
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					DriverFeature.getDriverManager().getCurrentDriver().operateTo(e.getX() - width / 2,
							e.getY() - height / 2);
					logger.warning("Operate to X:" + (e.getX() - width / 2) + " Y:" + (e.getY() - height / 2));
				} else if (SwingUtilities.isRightMouseButton(e)) {
					DriverFeature.getDriverManager().getCurrentDriver().setPosition(e.getX() - width / 2,
							e.getY() - height / 2);
					logger.warning("Set Position X:" + (e.getX() - width / 2) + " Y:" + (e.getY() - height / 2));
				}
			}
		});
	}

}
