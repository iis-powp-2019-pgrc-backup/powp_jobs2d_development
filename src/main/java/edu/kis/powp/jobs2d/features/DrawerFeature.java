package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.events.SelectClearPanelOptionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.kis.legacy.drawer.panel.DrawPanelController;

public class DrawerFeature {

	private static DrawPanelController drawerController;

	/**
	 * Setup Drawer Plugin and add to application.
	 * 
	 * @param application Application context.
	 */
	public static void setupDrawerPlugin(Application application) {
		SelectClearPanelOptionListener selectClearPanelOptionListener = new SelectClearPanelOptionListener();

		drawerController = new DrawPanelController();
		application.addComponentMenu(DrawPanelController.class, "Draw Panel", 0);
		application.addComponentMenuElement(DrawPanelController.class, "Clear Panel", selectClearPanelOptionListener);

		drawerController.initialize(application.getFreePanel());
	}

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

	/**
	 * Get controller of application drawing panel.
	 * 
	 * @return drawPanelController.
	 */
	public static DrawPanelController getDrawerController() {
		return drawerController;
	}
}
