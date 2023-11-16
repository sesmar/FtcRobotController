package Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class ChopChop {
    private final DcMotor _motorcd;
    private final Servo _pincher;

    private final LinearOpMode _myOpMode;

    private int lowerLimit = -47;
    private int upperLimit = -86;

    public ChopChop (DcMotor motorcd, Servo pincher, LinearOpMode myOpMode){
        _motorcd = motorcd;
        _pincher = pincher;
        _myOpMode = myOpMode;

        _motorcd.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void Move(double power) {
        int increment = 20;
        increment = (int)(increment * power);

        int targetPosition = _motorcd.getCurrentPosition()+increment;

		/*
        if (power < 0)
        {
            if (targetPosition < upperLimit) {
                targetPosition = upperLimit;
            }
        }
        else if (power > 0)
        {
            if (targetPosition > lowerLimit) {
                targetPosition = lowerLimit;
            }
        }
		*/

        if (power != 0){

            _motorcd.setTargetPosition(targetPosition);
        }
        else{
            _motorcd.setTargetPosition(_motorcd.getCurrentPosition());
            power = 1;
        }

        _motorcd.setPower(power);
        _motorcd.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void CorrectChop(String direction){

        _motorcd.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int targetPosition = -84;
        if(direction == "down"){ targetPosition = -targetPosition;}
        _motorcd.setTargetPosition(targetPosition);

        _motorcd.setPower(.5);

        _motorcd.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        _myOpMode.telemetry.addData("ChopChop: ", "Start Moving");

        while(_motorcd.isBusy()){
            //
        }

        _myOpMode.telemetry.addData("ChopChop: ", "Done Moving");

        _motorcd.setPower(0);
        _motorcd.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void Open()
    {
        _pincher.setPosition(.6);
    }

    public void Close()
    {
        _pincher.setPosition(.2);
    }

    public void ResetEncoder()
    {
        _motorcd.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void GetEncoderPosition()
    {
        _myOpMode.telemetry.addData("ChopChop", "%d", _motorcd.getCurrentPosition());
    }
}
