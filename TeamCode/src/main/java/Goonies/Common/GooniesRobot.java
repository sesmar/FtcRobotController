package Goonies.Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import Goonies.Autonomous.Programs.GooniesAutoRed1;

public class GooniesRobot  implements IRobot {

    public MecanumDriveTrain driveTrain;
    public LineSlide lineSlide;

    //public Climber climber;

    public Intake intake;

    public double drivePower = .75;
    public double turnPower = .5;

    public LinearOpMode myOpMode;

    public GooniesRobot(LinearOpMode opMode) {
        myOpMode = opMode;
    }

    public void Initialize(HardwareMap hardwareMap) {
        // Define and Initialize the DriveTrain
        DcMotor frontLeftMotor = hardwareMap.get(DcMotor.class, "flm");
        DcMotor frontRightMotor = hardwareMap.get(DcMotor.class, "frm");
        DcMotor backLeftMotor = hardwareMap.get(DcMotor.class, "blm");
        DcMotor backRightMotor = hardwareMap.get(DcMotor.class, "brm");
        IMU imu = hardwareMap.get(IMU.class, "imu");

        Gyro gyro = new Gyro(imu);
        driveTrain = new MecanumDriveTrain(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, gyro, myOpMode);

        DcMotor lineslide = hardwareMap.get(DcMotor.class, "linear");
        lineSlide = new LineSlide(lineslide);

        //Motors for the cliimers

        //DcMotor climberRightMotor = hardwareMap.get(DcMotor.class, "rcm");
        //DcMotor climberLeftMotor = hardwareMap.get(DcMotor.class, "lcm");

        //climber = new Climber(climberRightMotor, climberLeftMotor);
/*
        Servo lIntake = hardwareMap.get(Servo.class, "lIntake");
        DcMotor intakemover = hardwareMap.get(DcMotor.class, "intakelowerer");
        intake = new Intake(lIntake, intakemover);
        intake.Stop();
*/
    }

}

