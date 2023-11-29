package Autonomous.Vision;

import android.graphics.Canvas;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class StartingPositionProcessor implements VisionProcessor {
    private String location = "nothing";
    public Scalar lower = new Scalar(0,0,0);
    public Scalar upper = new Scalar(255,255,255);

    private Mat hsvMat = new Mat();
    private Mat binaryMat = new Mat();
    private Mat maskedInputMat = new Mat();

    //Rectangle regions to be scanned
    private Point topLeft1 = new Point(10, 0);
    private Point bottomRight1 = new Point(40, 20);

    private Point topLeft2 = new Point(10, 0);
    private Point bottomRight2 = new Point(40, 20);

    private Point topLeft3 = new Point(10, 0);
    private Point bottomRight3 = new Point(40, 20);

    public StartingPositionProcessor() {}

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }
    @Override
    public Mat processFrame(Mat input, long captureTimeNanos){
        Imgproc.cvtColor(input, hsvMat, Imgproc.COLOR_RGB2HSV);
        Core.inRange(hsvMat, lower, upper, binaryMat);

        double w1 = 0;
        double w2 = 0;
        double w3 = 0;

        for(int i = (int) topLeft1.x; i <= (int)bottomRight1.x; i++){
            for(int j = (int)topLeft1.y; j <= (int)bottomRight1.y; j++){
                if (binaryMat.get(i,j)[0] == 255) {
                    w1++;
                }
            }
        }

        return input;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {

    }
}
