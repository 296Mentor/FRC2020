package ca.northernknights.frc2019.dashboard;

import org.freedesktop.gstreamer.Gst;

public class Program {
	public static void main(String [] args) {
		// initialize GStreamer
        Gst.init("Dashboard296-2019", args);
		
		// construct a Dashboard window
		DashboardWindow window = new DashboardWindow();
		window.matchTimer.start();
		
		while (true) {
			window.repaint();
			
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// exit with OK
		//System.exit(0);
	}
}
