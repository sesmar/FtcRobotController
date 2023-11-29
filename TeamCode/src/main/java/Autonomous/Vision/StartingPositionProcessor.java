package Autonomous.Vision;

import android.graphics.Canvas;
import android.media.Image;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class StartingPositionProcessor implements VisionProcessor {
	public enum AllianceColor {
		RED,
		BLUE,
		NONE
	}

	public enum StartingBlock {
		A2,
		A4,
		F2,
		F4,
		NONE
	}


	public enum SpikeMarkPosition {
		RIGHT,
		LEFT,
		CENTER,
		NONE
	}

	public AllianceColor Alliance = AllianceColor.NONE;
	public StartingBlock Block = StartingBlock.NONE;
	public SpikeMarkPosition SpikeMark = SpikeMarkPosition.NONE;

	public int countLeft = 0;
	public int countRight = 0;

    public StartingPositionProcessor() {}

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }
    @Override
    public Mat processFrame(Mat input, long captureTimeNanos){
		Mat hsvMat = new Mat();
		Mat blueMat;
		Mat redMat;
		Mat returnMat = new Mat();

        Imgproc.cvtColor(input, hsvMat, Imgproc.COLOR_RGB2HSV);
		blueMat = generateBlueMat(hsvMat);
		redMat = generateRedMat(hsvMat);

		int blueCount = Core.countNonZero(blueMat);
		int redCount = Core.countNonZero(redMat);

		if (blueCount > redCount){
			returnMat = blueMat;
			Alliance = AllianceColor.BLUE;
		}
		else if (redCount > blueCount){
			returnMat = redMat;
			Alliance = AllianceColor.RED;
		}
		else{
			Imgproc.cvtColor(input, returnMat, Imgproc.COLOR_RGB2GRAY);
		}

		if (Alliance != AllianceColor.NONE){
			SpikeMark = determineTeamPropLocation(returnMat);
		}

        return returnMat;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {

    }

	public Mat generateBlueMat(Mat hsvMat){
		Scalar blueLower = new Scalar(110,100,20);
		Scalar blueUpper = new Scalar(130,255,255);
		Mat blueMat = new Mat();
		Core.inRange(hsvMat, blueLower, blueUpper, blueMat);

		return blueMat;
	}

	public Mat generateRedMat(Mat hsvMat){
		Mat redMat = new Mat();

		Mat rm1 = new Mat();
		Scalar redLower1 = new Scalar(0,100,20);
		Scalar redUpper1 = new Scalar(10,255,255);

		Mat rm2 = new Mat();
		Scalar redLower2 = new Scalar(160,100,20);
		Scalar redUpper2 = new Scalar(179,255,255);

		Core.inRange(hsvMat, redLower1, redUpper1, rm1);
		Core.inRange(hsvMat, redLower2, redUpper2, rm2);
		Core.add(rm1, rm2, redMat);

		return redMat;
	}

	public SpikeMarkPosition determineTeamPropLocation(Mat binaryMat){
		//Rectangle regions to be scanned
		Point topLeft1 = new Point(0, 0);
		Point bottomRight1 = new Point(479, 424);

		Point topLeft2 = new Point(0, 425);
		Point bottomRight2 = new Point(479, 639);

		int w1 = 0;
		int w2 = 0;

		int w1Threshold = 5000;
		int w2Threshold = 5000;

		SpikeMarkPosition spike = SpikeMarkPosition.NONE;

		for(int i = (int) topLeft1.x; i <= (int)bottomRight1.x; i++){
			for(int j = (int)topLeft1.y; j <= (int)bottomRight1.y; j++){
				if (binaryMat.get(i,j)[0] == 255) {
					w1++;
				}
			}
		}

		for(int i = (int) topLeft2.x; i <= (int)bottomRight2.x; i++){
			for(int j = (int)topLeft2.y; j <= (int)bottomRight2.y; j++){
				if (binaryMat.get(i,j)[0] == 255) {
					w2++;
				}
			}
		}

		if (w1 > w1Threshold){
			spike = SpikeMarkPosition.CENTER;
		}else if (w2 > w2Threshold){
			spike = SpikeMarkPosition.RIGHT;
		}else{
			spike = SpikeMarkPosition.LEFT;
		}

		countLeft = w1;
		countRight = w2;

		return spike;
	}
}
