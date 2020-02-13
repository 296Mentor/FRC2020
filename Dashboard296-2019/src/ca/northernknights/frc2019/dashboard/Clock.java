package ca.northernknights.frc2019.dashboard;

import java.awt.Graphics;
import java.awt.Label;

public class Clock extends Label {
  public Clock() {
	this.setAlignment(CENTER);
  }
  
  @Override
  public void paint(Graphics g) {
	this.setText(Long.toString(System.currentTimeMillis()));
	
	super.paint(g);
  }
}
