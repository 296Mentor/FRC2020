package ca.northernknights.frc2019.dashboard;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.freedesktop.gstreamer.Bin;
import org.freedesktop.gstreamer.Gst;
import org.freedesktop.gstreamer.Pipeline;
import org.freedesktop.gstreamer.examples.SimpleVideoComponent;

public class JetsonCameraComponent extends SimpleVideoComponent {
	private final Pipeline pipeline;
	private final int width, height;
	
	public JetsonCameraComponent(int width, int height) {
		super();
		
		// set local variables
		this.width = width;
		this.height = height;
		
		// setup the gstreamer pipeline
		Bin bin = Gst.parseBinFromDescription(
                "tcpclientsrc host=10.2.96.11 port=4953 ! h264parse ! openh264dec ! videoconvert ! capsfilter caps=video/x-raw,width=640,height=480",
                true);
//		Bin bin = Gst.parseBinFromDescription(
//      "tcpclientsrc host=10.2.96.20 port=4953 ! h264parse ! avdec_h264 ! videoconvert ! capsfilter caps=video/x-raw,width=640,height=480",
//      true);

		pipeline = new Pipeline();
		pipeline.addMany(bin, this.getElement());
        Pipeline.linkMany(bin, this.getElement());           

        this.setPreferredSize(new Dimension(width, height));
        
        pipeline.play();
	}

}
