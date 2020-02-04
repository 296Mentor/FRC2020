package ca.northernknights.frc2019.dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MatchTimer {
	private long matchStartTime;
	private boolean running;
	
	public void start() {
		this.running = true;
		this.matchStartTime = System.currentTimeMillis();
	}
	
	public void stop() {
		this.running = false;
	}
	
	public void reset() {
		this.running = false;
		
	}
	
	
	public void paint(Graphics g) {
		Rectangle bounds = g.getClipBounds();
		
		if (this.running) {
		
		// paint here
		g.setColor(Color.yellow);
		g.fillRect((int)(0.75 * bounds.width), 0, 10, 820);
		g.setColor(Color.green);
		g.fillRect((int)(0.75 * bounds.width), (int)(0.08 * bounds.height), 10, 820);
		g.setColor(Color.red);
		g.fillRect((int)(0.75 * bounds.width), (int)(0.75 * bounds.height), 10, 820);
		
		// compute how fast the chart should be disappearing
		int height = (int)((System.currentTimeMillis() - this.matchStartTime) * 0.0045555);
		g.setColor(DashboardWindow.DRIVER_STATION_BACKGROUND);
		g.fillRect((int)(0.75 * bounds.width), 0, 10, height);}
		
		

	}
}
