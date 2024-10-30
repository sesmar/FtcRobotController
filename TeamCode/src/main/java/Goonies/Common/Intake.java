package Goonies.Common;

import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private final Servo _lServo;
    private final Servo _rServo;

    public Intake(Servo lServo, Servo rServo){
        _lServo = lServo;
        _rServo = rServo;
    }
    public void Input(){
        _lServo.setPosition(0);
        _rServo.setPosition(1);
    }

    public void Output(){
        _lServo.setPosition(1);
        _rServo.setPosition(0);
    }

    public void Stop(){
        _lServo.setPosition(0.5);
        _rServo.setPosition(0.5);
    }
}
