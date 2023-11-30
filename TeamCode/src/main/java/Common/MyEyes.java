package Common;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

import Autonomous.Vision.StartingPositionProcessor;

public class MyEyes {
	private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera
	private final StartingPositionProcessor startingPositionProcessor;
	private final VisionPortal visionPortal;

	public SpikeMarkPosition getSpikeMark(){
		return startingPositionProcessor.SpikeMark;
	}

	public AllianceColor getAlliance(){
		return startingPositionProcessor.Alliance;
	}

	public MyEyes(WebcamName eyes, StartingPositionProcessor spp){
		startingPositionProcessor = spp;

		if (USE_WEBCAM) {
			visionPortal = VisionPortal.easyCreateWithDefaults(eyes, spp);
		} else {
			visionPortal = VisionPortal.easyCreateWithDefaults(BuiltinCameraDirection.FRONT, spp);
		}
	}

	public void close(){
		visionPortal.close();
	}
}
