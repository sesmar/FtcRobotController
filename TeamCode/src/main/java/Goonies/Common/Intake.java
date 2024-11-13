package Goonies.Common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private final Servo _lServo;
    private final DcMotor _intakeMotor;

    public Intake(Servo lServo, DcMotor intakeMotor) {
        _lServo = lServo;
        _intakeMotor = intakeMotor;
    }

    public void Input() {
        _lServo.setPosition(0);
    }

    public void Output() {
        _lServo.setPosition(1);
    }

    public void Stop() {
        _lServo.setPosition(0.5);
    }

    public void Move(double power) {
        _intakeMotor.setPower(power);
    }

    public void Dunk(){

    }
}