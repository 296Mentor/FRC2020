package ca.northernknights.frc2019.dashboard;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DashboardWindow extends JFrame {
	// for Serializable
	private static final long serialVersionUID = 1L;
	
	// some constants
	private final int DRIVER_STATION_HEIGHT = 200;
	private final Color DRIVER_STATION_BACKGROUND = new Color(42, 42, 42, 255);
	
	// private members
	private final Rectangle bounds;
	private final JetsonCameraComponent camera;
	
	public DashboardWindow() {
		// initialize the JFrame superclass by calling its constructor
		super("Northern Knights Dashboard");
		
		/*
		 * get some information
		 */
		// the graphics configuration for this window
		final GraphicsConfiguration graphicsConfiguration = this.getGraphicsConfiguration();
		
		// get the screen dimensions
		final Rectangle screenDimensions = graphicsConfiguration.getBounds();
		
		// get the insets of the screen (i.e., taskbar height)
		final Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(graphicsConfiguration); 
		
		// compute the bounds of the window
		this.bounds = new Rectangle(
				screenDimensions.x + screenInsets.left, // x
				screenDimensions.y + screenInsets.top,  // y
				screenDimensions.width - (screenInsets.left + screenInsets.right), // width
				screenDimensions.height - (screenInsets.top + screenInsets.bottom + DRIVER_STATION_HEIGHT) //height
				);

		/*
		 * setup the window
		 */
		// disable the border on this window
		this.setUndecorated(true);
		
		// set the window to fill the screen above the driver station
		this.setBounds(this.bounds);
				
		// set the window background to match that of the dashboard
		this.getContentPane().setBackground(DRIVER_STATION_BACKGROUND);
		
		// disable the LayoutManager
		this.setLayout(null);
		
		// initialize a JetsonCameraComponent
		if (bounds.width > 4 * bounds.height / 3) {
			this.camera = new JetsonCameraComponent(4 * bounds.height / 3, bounds.height);
			this.camera.setBounds(0, 0, 4 * bounds.height / 3, bounds.height);
		} else {
			this.camera = new JetsonCameraComponent(bounds.width, 3 * bounds.width / 4);
			this.camera.setBounds(0, 0, bounds.width, 3 * bounds.width / 4);
		}
		
		// add the Jetson camera on the left
		this.add(this.camera);
		
		
		
		// make the window visible		
		this.setVisible(true);
	}
	
}
