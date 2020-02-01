package ca.northernknights.frc2019.dashboard;

import org.freedesktop.gstreamer.Gst;

public class Program {
	public static void main(String [] args) {
		// initialize GStreamer
        Gst.init("Dashboard296-2019", args);
		
		// construct a Dashboard window
		DashboardWindow window = new DashboardWindow();
		
		while (true) {
			;
		}
		
		// exit with OK
		//System.exit(0);
	}
}
