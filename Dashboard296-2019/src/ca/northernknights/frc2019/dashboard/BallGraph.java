package ca.northernknights.frc2019.dashboard;

import java.awt.Color;
import java.awt.Graphics;



public class BallGraph {
	
	public boolean[] ballCounter;
	int ballcount;
	
	public BallGraph() {
		this.ballCounter = new boolean[5];
	}
	
	public void ballpickup() {
		
		for (int i = 0; i < ballcount; ++i) {
			ballCounter[i] = true;
		}
					
	}
	
	
	public void paint(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillOval(100, 700, 100, 100);
		g.fillOval(200, 700, 100, 100);
		g.fillOval(300, 700, 100, 100);
		g.fillOval(400, 700, 100, 100);
		g.fillOval(500, 700, 100, 100);
    
		if (ballCounter[0]) {
		g.setColor(Color.YELLOW);
	    g.fillOval(100, 700, 100, 100);
		}
		
		if (ballCounter[1]) {
		g.setColor(Color.YELLOW);
	    g.fillOval(200, 700, 100, 100);
		}
		
	    if (ballCounter[2]) {
	    g.setColor(Color.YELLOW);
	    g.fillOval(300, 700, 100, 100);
	    }
	    
	    if (ballCounter[3]) {
	    g.setColor(Color.YELLOW);
	    g.fillOval(400, 700, 100, 100);
	    }
	    
	    if (ballCounter[4]) {
	    g.setColor(Color.YELLOW);
	    g.fillOval(500, 700, 100, 100);
	    }
}
	
}