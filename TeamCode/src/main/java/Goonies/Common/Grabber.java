package Goonies.Common;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class Grabber {
    Servo _arm;
    Servo _pincher;
    LinearOpMode _myOpMode = null;

    public Grabber(Servo arm, Servo pincher, LinearOpMode opMode){
        _arm = arm;
        _pincher = pincher;
        _myOpMode = opMode;
    }

    public void positionForMoving(){
        positionForMoving(false);
    }

    public void positionForMoving(boolean forcedWait){
        _arm.setPosition(0);

        if (forcedWait) {
            double startTime = _myOpMode.getRuntime();

            while ((_myOpMode.getRuntime() - startTime) < 1) {
                //Waiting for the the desired time.
            }
        }
    }

    public void positionForGrabbing(){
        positionForGrabbing(false);
    }

    public void positionForGrabbing(boolean forcedWait){
        _arm.setPosition(1);

        if (forcedWait) {
            double startTime = _myOpMode.getRuntime();

            while ((_myOpMode.getRuntime() - startTime) < 1) {
                //Waiting for the the desired time.
            }
        }
    }

    public void positionForDunk(){
        positionForDunk(false);
    }

    public void positionForDunk(boolean forcedWait){
        _arm.setPosition(.1);

        if (forcedWait) {
            double startTime = _myOpMode.getRuntime();

            while ((_myOpMode.getRuntime() - startTime) < 1) {
                //Waiting for the the desired time.
            }
        }
    }

    public void open(){
        open(false);
    }

    public void open(boolean forcedWait){
        _pincher.setPosition(0);

        if (forcedWait) {
            double startTime = _myOpMode.getRuntime();

            while ((_myOpMode.getRuntime() - startTime) < 1) {
                //Waiting for the the desired time.
            }
        }
    }

    public void close(){
        close(false);
    }

    public void close(boolean forcedWait){
        _pincher.setPosition(1);

        if (forcedWait) {
            double startTime = _myOpMode.getRuntime();

            while ((_myOpMode.getRuntime() - startTime) < 1) {
                //Waiting for the the desired time.
            }
        }
    }
}
