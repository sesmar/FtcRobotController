package Goonies.Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class GooniesRobot  implements IRobot {

    public MecanumDriveTrain driveTrain;
    public LineSlide linearSlide;

    //public Climber climber;

    public Grabber grabber;

    public double drivePower = .75;
    public double turnPower = .5;

    private LinearOpMode _myOpMode = null;

    public GooniesRobot(LinearOpMode opMode) {
        _myOpMode = opMode;
    }

    public void Initialize(HardwareMap hardwareMap) {
        // Define and Initialize the DriveTrain
        DcMotor frontLeftMotor = hardwareMap.get(DcMotor.class, "flm");
        DcMotor frontRightMotor = hardwareMap.get(DcMotor.class, "frm");
        DcMotor backLeftMotor = hardwareMap.get(DcMotor.class, "blm");
        DcMotor backRightMotor = hardwareMap.get(DcMotor.class, "brm");
        IMU imu = hardwareMap.get(IMU.class, "imu");

        Gyro gyro = new Gyro(imu);
        driveTrain = new MecanumDriveTrain(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, gyro, _myOpMode);

        //The Linear Slide is driven by one motor.
        DcMotor lineSlide = hardwareMap.get(DcMotor.class, "linear");
        TouchSensor linearTs = _myOpMode.hardwareMap.get(TouchSensor.class,"linearTs");
        linearSlide = new LineSlide(lineSlide, linearTs);

        //Grabber class, 2 servos, one to controller the "arm" and the other for the "pincher"
        Servo arm = hardwareMap.get(Servo.class, "arm");
        Servo pincher = hardwareMap.get(Servo.class, "pincher");
        grabber = new Grabber(arm, pincher, _myOpMode);

        //Motors for the cliimber
        //DcMotor climberRightMotor = hardwareMap.get(DcMotor.class, "rcm");
        //DcMotor climberLeftMotor = hardwareMap.get(DcMotor.class, "lcm");

        //climber = new Climber(climberRightMotor, climberLeftMotor);
    }
}

