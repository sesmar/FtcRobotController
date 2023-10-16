/* Copyright (c) 2023 The Goonies. All rights reserved.

 */

package Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class CalamariRobot {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

	public MecanumDriveTrain driveTrain;

	public LiftArm liftArm;

    public ChopChop chopChop;

    public FunnelCake funnelCake;

    // Define a constructor that allows the OpMode to pass a reference to itself.
    public CalamariRobot (LinearOpMode opmode) {
        myOpMode = opmode;
    }

    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     * <p>
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
    public void init()    {
		// Define and Initialize the DriveTrain
		DcMotor leftFrontDrive   = myOpMode.hardwareMap.get(DcMotor.class, "lfm");
		//leftFrontDrive  = myOpMode.hardwareMap.get(DcMotor.class, "LFM");
		DcMotor rightFrontDrive  = myOpMode.hardwareMap.get(DcMotor.class, "RFM");
		DcMotor leftBackDrive   = myOpMode.hardwareMap.get(DcMotor.class, "LBM");
		DcMotor rightBackDrive  = myOpMode.hardwareMap.get(DcMotor.class, "RBM");
        IMU imu = myOpMode.hardwareMap.get(IMU.class, "imu");

        CalamariGyro gyro = new CalamariGyro(imu);
		driveTrain = new MecanumDriveTrain(leftFrontDrive, leftBackDrive, rightFrontDrive, rightBackDrive, gyro, myOpMode);

		//Initialize the LiftArm
        DcMotor liftMotor   = myOpMode.hardwareMap.get(DcMotor.class, "lift");
        TouchSensor liftTsDown = myOpMode.hardwareMap.get(TouchSensor.class,"LiftS");
        TouchSensor liftTsUp = myOpMode.hardwareMap.get(TouchSensor.class,"LiftTS");

		liftArm = new LiftArm(liftMotor, liftTsDown, liftTsUp, myOpMode.telemetry);

        DcMotor rotomcd = myOpMode.hardwareMap.get(DcMotor.class, "ChopChop");
        chopChop = new ChopChop(rotomcd);

        DcMotor motocd = myOpMode.hardwareMap.get(DcMotor.class, "FunnelCake");
        funnelCake = new FunnelCake(motocd);

        driveTrain.stop();

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }
}