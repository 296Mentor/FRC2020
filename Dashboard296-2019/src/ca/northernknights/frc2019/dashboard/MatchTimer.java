package ca.northernknights.frc2019.dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MatchTimer {
	private final int AUTO_TIME = 15;
	private final int TELEOP_TIME = 135;
	private final int ENDGAME_TIME = 30; 
	private final int TOTAL_TIME = AUTO_TIME + TELEOP_TIME + ENDGAME_TIME;
	
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
			final double autoFraction = (double)AUTO_TIME / TOTAL_TIME;
			final double teleopFraction = (double)TELEOP_TIME / TOTAL_TIME;
			final double endGameFraction = (double)ENDGAME_TIME / TOTAL_TIME;
			
			g.setColor(Color.yellow);
			g.fillRect(bounds.x, bounds.y, bounds.width, (int)(autoFraction * bounds.height));
			g.setColor(Color.green);
			g.fillRect(bounds.x, bounds.y + (int)(autoFraction * bounds.height), bounds.width, (int)(teleopFraction * bounds.height));
			g.setColor(Color.red);
			g.fillRect( bounds.x, bounds.y + (int)((autoFraction + teleopFraction) * bounds.height), bounds.width, (int)(endGameFraction * bounds.height));
			
			// compute how fast the chart should be disappearing
			int height = (int)((System.currentTimeMillis() - this.matchStartTime) * ((double)bounds.height / (TOTAL_TIME * 1000)));
			g.setColor(DashboardWindow.DRIVER_STATION_BACKGROUND);
			g.fillRect(bounds.x, bounds.y, bounds.width, height);
		}
	}

	}


