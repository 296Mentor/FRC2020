package ca.northernknights.frc2019.dashboard;

import java.awt.Graphics;
import java.awt.Label;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Label {
	private long matchStartTime;
	private TimerTask timerTask;
	private boolean running;
	
	private Timer timer;

	long DisplayTime = 3 * 60 * 1000;
	int gamelenght = 3000;

	public void start() {
		this.running = true;
		this.matchStartTime = System.currentTimeMillis();
		this.timerTask = new TimerTask() {
				@Override
				public void run() {
					repaint();
				}
			};
		this.timer.schedule(this.timerTask, 0, 30);
	}

	public void stop() {
		this.running = false;
		
		if (this.timerTask != null) {
			this.timerTask.cancel();
		}
		
		this.timerTask = null;
	}

	public void reset() {
		this.stop();
		this.start();
	}

	public Clock() {
		this.setAlignment(CENTER);
		this.running = false;
		this.timer = new Timer();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		this.setText(Long.toString(Math.abs( 180 - (System.currentTimeMillis() - this.matchStartTime)/1000 )));
	}

}