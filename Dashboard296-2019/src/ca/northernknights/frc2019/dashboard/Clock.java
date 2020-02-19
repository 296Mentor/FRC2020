package ca.northernknights.frc2019.dashboard;

import java.awt.Graphics;
import java.awt.Label;
import java.util.Date;

public class Clock extends Label {

	
	
	private long matchStartTime;
	private boolean running;
	
	long DisplayTime = 3 * 60 * 1000;
	int gamelenght = 3000;
	
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
	

	public Clock() {
		this.setAlignment(CENTER);
	}

	
	
	
	@Override
	public void paint(Graphics g) {

		

		this.setText(Long.toString( 1 * (gamelenght - matchStartTime)));

		super.paint(g);
	}
	
		
}


