package Goonies.Common;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MecanumDriveTrain {
    //define static variables for use within the program
    //Wheel Diameter
    public static final double wheelDiameter = 2.875;

    public static final double wheelCircumference = Math.PI * wheelDiameter;
    //Counts Per Revolution for the Drive Motors
    public static final double CPR = 560;

    //Count Per Inch for the Drive Motors
    public static final double CPI = CPR/wheelCircumference;

    //define motors for driving the robot
    private final DcMotor _leftFront;
    private final DcMotor _leftBack;
    private final DcMotor _rightFront;
    private final DcMotor _rightBack;

    public MecanumDriveTrain(DcMotor leftFront, DcMotor leftBack, DcMotor rightFront, DcMotor rightBack){
        _leftFront = leftFront;
        _leftBack = leftBack;
        _rightFront = rightFront;
        _rightBack = rightBack;

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
}