/* Copyright (c) 2023 The Goonies. All rights reserved.

 */

package Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import Autonomous.Vision.StartingPositionProcessor;

public class CalamariRobot {
	/*Declare Static Variables*/
	public static final double drivePower = .75;
	public static final double turnPower = .4;

	public Boolean hasVision = false;

    /* Declare OpMode members. */
    public LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

	public MecanumDriveTrain driveTrain;

	public LiftArm liftArm;

    public MagicRope magicRope;

    public ChopChop chopChop;

    public FunnelCake funnelCake;

    public AirForceLaunch airForceLaunch;

	public MyEyes myEyes;

	public EggDropper eggDropper;

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

		//Initialize ChopChop
		Servo neck = myOpMode.hardwareMap.get(Servo.class, "neck");
        Servo pincher = myOpMode.hardwareMap.get(Servo.class, "pincher");
        chopChop = new ChopChop(neck, pincher, myOpMode);

		//Initialize FunnelCake
        DcMotor motorcd = myOpMode.hardwareMap.get(DcMotor.class, "FunnelCake");
        funnelCake = new FunnelCake(motorcd);

        //Initialize the MagicRope
        DcMotor ropeMotor   = myOpMode.hardwareMap.get(DcMotor.class, "MagicianRope");
        magicRope = new MagicRope(ropeMotor);

		//Initialize AirForceLaunch
        Servo launcher = myOpMode.hardwareMap.get(Servo.class, "AirForceLaunch");
        airForceLaunch = new AirForceLaunch(launcher);

		Servo eggDrop1 = myOpMode.hardwareMap.get(Servo.class, "eggdrop1");
		Servo eggDrop2 = myOpMode.hardwareMap.get(Servo.class, "eggdrop2");
		eggDropper = new EggDropper(eggDrop1,eggDrop2);
		eggDropper.Secure(1);
		eggDropper.Secure(2);

		if (hasVision) {
			StartingPositionProcessor spp = new StartingPositionProcessor();
			WebcamName itsEyes = myOpMode.hardwareMap.get(WebcamName.class, "ItHasEYES");
			myEyes = new MyEyes(itsEyes, spp);
		}

        driveTrain.stop();

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }
}