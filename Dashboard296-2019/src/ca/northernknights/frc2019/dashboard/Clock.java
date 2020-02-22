package ca.northernknights.frc2019.dashboard;

import java.awt.Graphics;
import java.awt.Label;
import java.util.Date;

public class Clock extends Label {
	private long matchStartTime;
	private boolean running;

	long DisplayTime = 3 * 60 * 1000;
	int gamelenght = 3000;
	private long firstvalue;

	public void start() {
		this.running = true;
		this.matchStartTime = System.currentTimeMillis();
        this.firstvalue =  System.currentTimeMillis();
	}

	public void stop() {
		this.running = false;
	}

	public void reset() {
		this.running = false;

	}

	public Clock() {
		this.setAlignment(CENTER);
	}

	@Override
	public void paint(Graphics g) {
		this.firstvalue = System.currentTimeMillis();
		while (true) {
			
			this.matchStartTime = System.currentTimeMillis();
			
			this.setText(Long.toString(1 * (Math.abs( 180 - (matchStartTime - firstvalue)/1000 ))));

			super.paint(g);
		}
	}

}