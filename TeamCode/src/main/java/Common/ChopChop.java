package Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Objects;

public class ChopChop {
    private final Servo _neck;
    private final Servo _pincher;

    private final LinearOpMode _myOpMode;

    private int lowerLimit = -47;
    private int upperLimit = -86;

    public ChopChop (Servo neck, Servo pincher, LinearOpMode myOpMode){
        _neck = neck;
        _pincher = pincher;
        _myOpMode = myOpMode;

    }

    public void Move(double power) {
        double increment = .02;
        increment = (increment * power);

        double targetPosition = _neck.getPosition()+increment;

		if(targetPosition < 0){
			targetPosition = 0;
		} else if(targetPosition > 1){
			targetPosition = 1;
		}
        _neck.setPosition(targetPosition);

    }

    public void CorrectChop(String direction){

        if(Objects.equals(direction, "up")){
			_neck.setPosition(.570);
		}else {
			_neck.setPosition(0);
		}


    }

    public void Open()
    {
        _pincher.setPosition(.6);
    }

    public void Close()
    {
        _pincher.setPosition(.2);
    }

}
