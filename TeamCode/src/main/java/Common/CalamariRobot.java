/* Copyright (c) 2023 The Goonies. All rights reserved.

 */

package Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class CalamariRobot {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

	public MecanumDriveTrain driveTrain;
    public DcMotor liftMotor = null;

    public TouchSensor liftts;  // Touch sensor Object

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
		// Define and Initialize Motors (note: need to use reference to actual OpMode).
		DcMotor leftFrontDrive   = myOpMode.hardwareMap.get(DcMotor.class, "lfm");
		//leftFrontDrive  = myOpMode.hardwareMap.get(DcMotor.class, "LFM");
		DcMotor rightFrontDrive  = myOpMode.hardwareMap.get(DcMotor.class, "RFM");
		DcMotor leftBackDrive   = myOpMode.hardwareMap.get(DcMotor.class, "LBM");
		DcMotor rightBackDrive  = myOpMode.hardwareMap.get(DcMotor.class, "RBM");

		driveTrain = new MecanumDriveTrain(leftFrontDrive, leftBackDrive, rightFrontDrive, rightBackDrive, myOpMode.telemetry);

        liftMotor   = myOpMode.hardwareMap.get(DcMotor.class, "lift");
        liftts = myOpMode.hardwareMap.get(TouchSensor.class,"LiftS");

        driveTrain.stop();

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }
}