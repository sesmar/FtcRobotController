package Goonies.Common;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class LineSlide {
    private final DcMotor _motorcycle;
    private final TouchSensor _linearTs;
    private final double runPower = 0.33;

    public LineSlide(DcMotor motorcycle, TouchSensor linearTs) {
        _motorcycle = motorcycle;
        _linearTs = linearTs;
    }

    public void Movercycle(double power)
    {
        if (!_linearTs.isPressed())
        {
            _motorcycle.setPower(-power);
        }
    }

    public void stop(){
        _motorcycle.setPower(0);
    }

    private void runByEncoder(int rotations, double power){
        _motorcycle.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int targetPosition = (288 * 3);

        if (power < 0) {
            targetPosition = targetPosition * -1;
        }

        _motorcycle.setTargetPosition(targetPosition);
        _motorcycle.setPower(power);

        _motorcycle.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (_motorcycle.isBusy()) {
            //Wait for the motor to finish running.
        }

        stop();
        _motorcycle.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void drive() {
        runByEncoder(3, -runPower);
    }

    public void retract(){
        runByEncoder(3, runPower);
    }
}