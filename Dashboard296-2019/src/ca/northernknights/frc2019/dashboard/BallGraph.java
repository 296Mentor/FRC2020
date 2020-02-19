package ca.northernknights.frc2019.dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



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
		Rectangle bounds = g.getClipBounds();
		
		g.setColor(Color.WHITE);
		g.fillOval(bounds.x, bounds.y, (int) (bounds.width/3.5), (int) (bounds.height/3.5));
		g.fillOval((int) (bounds.x + bounds.width/5.6), (int) (bounds.y + bounds.height/3.5), (int) (bounds.width/3.5), (int) (bounds.height/3.5));
		g.fillOval((int) (bounds.x + 2*(bounds.width/5.6)), bounds.y, (int) (bounds.width/3.5), (int) (bounds.height/3.5));
		g.fillOval((int) (bounds.x + 3*(bounds.width/5.6)), (int) (bounds.y + bounds.height/3.5), (int) (bounds.width/3.5), (int) (bounds.height/3.5));
		g.fillOval((int) (bounds.x + 4*(bounds.width/5.6)), bounds.y, (int) (bounds.width/3.5), (int) (bounds.height/3.5));
    
		if (ballCounter[0]) {
		g.setColor(Color.YELLOW);
	    g.fillOval(bounds.x, bounds.y, (int) (bounds.width/3.5), (int) (bounds.height/3.5));
		}
		
		if (ballCounter[1]) {
		g.setColor(Color.YELLOW);
	    g.fillOval((int) (bounds.x + bounds.width/5.6), (int) (bounds.y + bounds.height/3.5), (int) (bounds.width/3.5), (int) (bounds.height/3.5));
		}
		
	    if (ballCounter[2]) {
	    g.setColor(Color.YELLOW);
	    g.fillOval((int) (bounds.x + 2*(bounds.width/5.6)), bounds.y, (int) (bounds.width/3.5), (int) (bounds.height/3.5));
	    }
	    
	    if (ballCounter[3]) {
	    g.setColor(Color.YELLOW);
	    g.fillOval((int) (bounds.x + 3*(bounds.width/5.6)), (int) (bounds.y + bounds.height/3.5), (int) (bounds.width/3.5), (int) (bounds.height/3.5));
	    }
	    
	    if (ballCounter[4]) {
	    g.setColor(Color.YELLOW);
	    g.fillOval((int) (bounds.x + 4*(bounds.width/5.6)), bounds.y, (int) (bounds.width/3.5), (int) (bounds.height/3.5));
	    }
}
	
}