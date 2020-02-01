package ca.northernknights.frc2019.dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DashboardWindow extends JFrame {
	// for Serializable
	private static final long serialVersionUID = 1L;
	
	// some constants
	private final int DRIVER_STATION_HEIGHT = 200;
	private final Color DRIVER_STATION_BACKGROUND = new Color(42, 42, 42, 255);
	
	// private members
	private final Rectangle bounds;
//	private final JetsonCameraComponent camera;
	private Image backBuffer = null;
	
	private int x = 0;
	private long matchStartTime;
	
	public DashboardWindow() {
		// initialize the JFrame superclass by calling its constructor
		super("Northern Knights Dashboard");
		
		// get the start time (TODO: do this when the match starts)
		matchStartTime = System.currentTimeMillis();
		
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
		this.setBackground(DRIVER_STATION_BACKGROUND);
		
		// disable the LayoutManager
		this.setLayout(null);
		
		// stop the program when the window is closed
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
//		// initialize a JetsonCameraComponent
//		if (bounds.width > 4 * bounds.height / 3) {
//			this.camera = new JetsonCameraComponent(4 * bounds.height / 3, bounds.height);
//			this.camera.setBounds(0, 0, 4 * bounds.height / 3, bounds.height);
//		} else {
//			this.camera = new JetsonCameraComponent(bounds.width, 3 * bounds.width / 4);
//			this.camera.setBounds(0, 0, bounds.width, 3 * bounds.width / 4);
//		}
//		
//		// add the Jetson camera on the left
//		this.add(this.camera);
		
		// make the window visible		
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics _g) {
		// setup the back buffer
		if (this.backBuffer == null) {
			this.backBuffer = createImage(this.bounds.width, this.bounds.height);			
		}

		Graphics g = this.backBuffer.getGraphics();
		g.setColor(DRIVER_STATION_BACKGROUND);
		g.fillRect(0, 0, this.bounds.width, this.bounds.height);

		// paint here
		g.setColor(Color.yellow);
		g.fillRect((int)(0.75 * this.bounds.width), 0, 10, 820);
		g.setColor(Color.green);
		g.fillRect((int)(0.75 * this.bounds.width), (int)(0.08 * this.bounds.height), 10, 820);
		g.setColor(Color.red);
		g.fillRect((int)(0.75 * this.bounds.width), (int)(0.75 * this.bounds.height), 10, 820);
		
		// compute how tall this triangle should be
		int height = (int)((System.currentTimeMillis() - this.matchStartTime) * 0.0045555);
		g.setColor(DRIVER_STATION_BACKGROUND);
		g.fillRect((int)(0.75 * this.bounds.width), 0, 10, height);

		// draw the back buffer
		_g.drawImage(this.backBuffer, 0, 0, null);
	}
	
}