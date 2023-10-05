/* Copyright (c) 2022 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/*
 * This file works in conjunction with the External Hardware Class sample called: ConceptExternalHardwareClass.java
 * Please read the explanations in that Sample about how to use this class definition.
 *
 * This file defines a Java Class that performs all the setup and configuration for a sample robot's hardware (motors and sensors).
 * It assumes three motors (left_drive, right_drive and arm) and two servos (left_hand and right_hand)
 *
 * This one file/class can be used by ALL of your OpModes without having to cut & paste the code each time.
 *
 * Where possible, the actual hardware objects are "abstracted" (or hidden) so the OpMode code just makes calls into the class,
 * rather than accessing the internal hardware directly. This is why the objects are declared "private".
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with *exactly the same name*.
 *
 * Or... In OnBot Java, add a new file named RobotHardware.java, select this sample, and select Not an OpMode.
 * Also add a new OpMode, select the sample ConceptExternalHardwareClass.java, and select TeleOp.
 *
 */

public class CalamariRobot {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    public DcMotor leftFrontDrive   = null;
    public DcMotor rightFrontDrive  = null;
    public DcMotor leftBackDrive   = null;
    public DcMotor rightBackDrive  = null;
    public DcMotor liftMotor = null;

    public TouchSensor liftts;  // Touch sensor Object

    //define static variables for use within the program
    //Wheel Diameter
    public static final double wheelDiameter = 2.875;

    public static final double wheelCircumference = Math.PI * wheelDiameter;
    //Counts Per Revolution for the Drive Motors
    public static final double CPR = 560;

    //Count Per Inch for the Drive Motors
    public static final double CPI = CPR/ wheelCircumference;


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
        //leftFrontDrive  = myOpMode.hardwareMap.get(DcMotor.class, "LFM");
        leftFrontDrive  = myOpMode.hardwareMap.get(DcMotor.class, "lfm");
		leftBackDrive  = myOpMode.hardwareMap.get(DcMotor.class, "LBM");

        rightFrontDrive = myOpMode.hardwareMap.get(DcMotor.class, "RFM");
		rightBackDrive = myOpMode.hardwareMap.get(DcMotor.class, "RBM");

        liftMotor   = myOpMode.hardwareMap.get(DcMotor.class, "lift");
        liftts = myOpMode.hardwareMap.get(TouchSensor.class,"LiftS");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
		leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
		leftBackDrive.setDirection(DcMotor.Direction.REVERSE);

		rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
		rightBackDrive .setDirection(DcMotor.Direction.FORWARD);

        stopRobot();

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }

    /**
     * Sets the power on all drive motors to 0.
     *
     */
	public void stopRobot() {
		leftFrontDrive.setPower(0);
		leftBackDrive.setPower(0);
		rightFrontDrive.setPower(0);
		rightBackDrive .setPower(0);
	}

    /**
     * Pass the requested wheel motor powers to the appropriate hardware drive motors.
     *
     * @param power     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     */
    public void setDrivePower(double power) {
        // Output the values to the motor drives.
		setDrivePower(power, power, power, power);
    }

    /**
     * Pass the requested wheel motor powers to the appropriate hardware drive motors.
     *
     * @param leftFront     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param leftBack     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param rightFront     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     * @param rightBack     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     */
    public void setDrivePower(double leftFront, double leftBack, double rightFront, double rightBack) {
        // Output the values to the motor drives.
        leftFrontDrive.setPower(leftFront);
        leftBackDrive.setPower(leftBack);
        rightFrontDrive.setPower(rightFront);
        rightBackDrive .setPower(rightBack);
    }

    /**
     * Pass the requested wheel motor powers to the appropriate hardware drive motors.
     *
     * @param inches the number of inches to move
     * @param power     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
     */
    public void driveForInches(int inches, double power){
        setDriveMotorMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setDriveMotorsTargetPosition(inches*CPI);

        setDrivePower(power);

        setDriveMotorMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(leftFrontDrive.isBusy() || leftBackDrive.isBusy() || rightFrontDrive.isBusy() || rightBackDrive.isBusy()){
            myOpMode.telemetry.addData("Status", "Driving");
            myOpMode.telemetry.addData("Left Front Power", "%.2f", leftFrontDrive.getPower());
            myOpMode.telemetry.addData("Right Front Power", "%.2f", rightFrontDrive.getPower());
            myOpMode.telemetry.update();
        }

        stopRobot();
        setDriveMotorMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setDriveMotorMode(DcMotor.RunMode runMode){
        leftFrontDrive.setMode(runMode);
        leftBackDrive.setMode(runMode);
        rightFrontDrive.setMode(runMode);
        rightBackDrive.setMode(runMode);
    }

    public void setDriveMotorsTargetPosition(double targetPosition) {
        double correctedTargetPosition = 0.0;

        correctedTargetPosition = leftFrontDrive.getCurrentPosition() + targetPosition;
        leftFrontDrive.setTargetPosition((int)correctedTargetPosition);

        correctedTargetPosition = leftBackDrive.getCurrentPosition() + targetPosition;
        leftBackDrive.setTargetPosition((int)correctedTargetPosition);

        correctedTargetPosition = rightFrontDrive.getCurrentPosition() + targetPosition;
        rightFrontDrive.setTargetPosition((int)correctedTargetPosition);

        correctedTargetPosition = rightBackDrive.getCurrentPosition() + targetPosition;
        rightBackDrive.setTargetPosition((int)correctedTargetPosition);
    }

    public void turnLeft(int seconds, double power){
        myOpMode.resetRuntime();

        while (myOpMode.getRuntime() < seconds) {
            leftFrontDrive.setPower(-power);
            leftBackDrive.setPower(-power);
            rightFrontDrive.setPower(power);
            rightBackDrive.setPower(power);
        }

        stopRobot();
    }

    public void turnRight(int seconds, double power){
        myOpMode.resetRuntime();

        while (myOpMode.getRuntime() < seconds) {
            leftFrontDrive.setPower(power);
            leftBackDrive.setPower(power);
            rightFrontDrive.setPower(-power);
            rightBackDrive.setPower(-power);
        }

        stopRobot();
    }
}