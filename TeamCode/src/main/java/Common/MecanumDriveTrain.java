package Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDriveTrain {
	//define static variables for use within the program
	//Wheel Diameter
	public static final double wheelDiameter = 2.875;

	public static final double wheelCircumference = Math.PI * wheelDiameter;
	//Counts Per Revolution for the Drive Motors
	public static final double CPR = 560;

	//Count Per Inch for the Drive Motors
	public static final double CPI = CPR/ wheelCircumference;

	//define motors for driving the robot
	private final DcMotor _leftFront;
	private final DcMotor _leftBack;
	private final DcMotor _rightFront;
	private final DcMotor _rightBack;

	private final CalamariGyro _gyro;

	private final LinearOpMode _myOpMode;

	public MecanumDriveTrain(DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack, CalamariGyro gyro, LinearOpMode myOpMode){
		_leftFront = leftFront;
		_leftBack = leftBack;
		_rightFront = rightFront;
		_rightBack = rightBack;
		_gyro = gyro;
		_myOpMode = myOpMode;

		// To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
		_leftFront.setDirection(DcMotor.Direction.REVERSE);
		_leftBack.setDirection(DcMotor.Direction.REVERSE);

		_rightFront.setDirection(DcMotor.Direction.FORWARD);
		_rightBack .setDirection(DcMotor.Direction.FORWARD);
	}

	/**
	 * Sets the power on all drive motors to 0.
	 *
	 */
	public void stop(){
		setPower(0);
	}

	/**
	 * Pass the requested wheel motor powers to the appropriate hardware drive motors.
	 *
	 * @param power     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
	 */
	public void setPower(double power){
		setPower(power, power, power, power);
	}

	/**
	 * Pass the requested wheel motor powers to the appropriate hardware drive motors.
	 *
	 * @param lfPower     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
	 * @param lbPower     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
	 * @param rfPower     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
	 * @param rbPower     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
	 */
	public void setPower(double lfPower, double lbPower, double rfPower, double rbPower){
		_leftFront.setPower(lfPower);
		_leftBack.setPower(lbPower);
		_rightFront.setPower(rfPower);
		_rightBack.setPower(rbPower);
	}

	/**
	 * Pass the requested wheel motor powers to the appropriate hardware drive motors.
	 *
	 * @param inches the number of inches to move
	 * @param power     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
	 */
	public void driveForInches(int inches, double power){
		setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

		int targetPosition = (int)(inches*CPI);

		if (power < 0) { targetPosition = targetPosition * -1; }

		setTargetPosition(targetPosition);

		setPower(power);

		setMode(DcMotor.RunMode.RUN_TO_POSITION);

		while(_leftFront.isBusy() || _leftBack.isBusy() || _rightFront.isBusy() || _rightBack.isBusy()){
			_myOpMode.telemetry.addData("Status", "Driving");
			_myOpMode.telemetry.addData("Left Front Power", "%.2f", _leftFront.getPower());
			_myOpMode.telemetry.addData("Right Front Power", "%.2f", _rightFront.getPower());
			_myOpMode.telemetry.addData("Left Back Power", "%.2f", _leftBack.getPower());
			_myOpMode.telemetry.addData("Right Back Power", "%.2f", _rightBack.getPower());
		}

		stop();
		setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
	}

	public void driveSidewaysForInches(int inches, double power){
		setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

		int targetPosition = (int)(inches*CPI);

		if (power < 0) { targetPosition = targetPosition * -1; }

		setTargetPosition(-targetPosition, targetPosition, targetPosition, -targetPosition);

		setPower(power);

		setMode(DcMotor.RunMode.RUN_TO_POSITION);

		while(_leftFront.isBusy() || _leftBack.isBusy() || _rightFront.isBusy() || _rightBack.isBusy()){
			_myOpMode.telemetry.addData("Status", "Driving");
			_myOpMode.telemetry.addData("Left Front Power", "%.2f", _leftFront.getPower());
			_myOpMode.telemetry.addData("Right Front Power", "%.2f", _rightFront.getPower());
			_myOpMode.telemetry.addData("Left Back Power", "%.2f", _leftBack.getPower());
			_myOpMode.telemetry.addData("Right Back Power", "%.2f", _rightBack.getPower());
		}

		stop();
		setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
	}

	private void setMode(DcMotor.RunMode runMode){
		_leftFront.setMode(runMode);
		_leftBack.setMode(runMode);
		_rightFront.setMode(runMode);
		_rightBack.setMode(runMode);
	}

	private void setTargetPosition(double targetPosition) {
		setTargetPosition(targetPosition, targetPosition, targetPosition, targetPosition);
	}

	private void setTargetPosition(double lfPosition, double lbPosition, double rfPosition, double rbPosition) {
		double correctedTargetPosition = _leftFront.getCurrentPosition() + lfPosition;
		_leftFront.setTargetPosition((int)correctedTargetPosition);

		correctedTargetPosition = _leftBack.getCurrentPosition() + lbPosition;
		_leftBack.setTargetPosition((int)correctedTargetPosition);

		correctedTargetPosition = _rightFront.getCurrentPosition() + rfPosition;
		_rightFront.setTargetPosition((int)correctedTargetPosition);

		correctedTargetPosition = _rightBack.getCurrentPosition() + rbPosition;
		_rightBack.setTargetPosition((int)correctedTargetPosition);
	}

	/**
	 * To turn left pass a positive value and to turn right pass a negative value
	 *
	 * @param degrees the number of degrees to turn
	 * @param power     Fwd/Rev driving power (-1.0 to 1.0) +ve is forward
	 */
	public void turn(int degrees, double power){
		int drift = 12;
		_gyro.resetYaw();
		while (Math.abs(_gyro.getYaw()) < (Math.abs(degrees)-drift)) {
			_leftFront.setPower(-power);
			_leftBack.setPower(-power);
			_rightFront.setPower(power);
			_rightBack.setPower(power);
		}

		stop();
	}
}