package Goonies.Common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class GooniesRobot  implements IRobot{

    public MecanumDriveTrain driveTrain;
    public LineSlide lineSlide;

    public Climber climber;

    public Intake intake;

    public void Initialize(HardwareMap hardwareMap){
        // Define and Initialize the DriveTrain
        DcMotor frontLeftMotor = hardwareMap.get(DcMotor.class, "flm");
        DcMotor frontRightMotor = hardwareMap.get(DcMotor.class, "frm");
        DcMotor backLeftMotor = hardwareMap.get(DcMotor.class, "blm");
        DcMotor backRightMotor = hardwareMap.get(DcMotor.class, "brm");

        driveTrain = new MecanumDriveTrain(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

        DcMotor lineslide = hardwareMap.get(DcMotor.class, "linear");
        lineSlide = new LineSlide(lineslide);

        //Motors for the cliimers

        DcMotor climberRightMotor = hardwareMap.get(DcMotor.class, "rcm");
        DcMotor climberLeftMotor = hardwareMap.get(DcMotor.class, "lcm");

        climber = new Climber(climberRightMotor, climberLeftMotor);

        Servo lIntake = hardwareMap.get(Servo.class, "lIntake");
        Servo rIntake = hardwareMap.get(Servo.class, "rIntake");
        intake = new Intake(lIntake, rIntake);
        intake.Stop();
    }
}
