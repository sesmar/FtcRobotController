package Goonies.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import Goonies.Common.GooniesRobot;

public class GamePad1  implements IGamePad{
    private static final double fortyFiveRads = -Math.PI/4;
    private static final double cosine45 = Math.cos(fortyFiveRads);
    private static final double sine45 = Math.sin(fortyFiveRads);
    private final GooniesRobot _robot;
    private final Gamepad _gamePad;

    public GamePad1(Gamepad gamePad, GooniesRobot robot){
        _gamePad = gamePad;
        _robot = robot;
    }
    public void HandleInput(){
        double x1; //left/right
        double y1; //forward/back
        double x2; //rotated 45 degrees counterclockwise
        double y2; //rotates 45 degrees counterclockwise
        double spin  = _gamePad.right_stick_x;

        if (Math.abs(spin) > 0.1){
            int reduction = 2;

            if (_gamePad.right_bumper){reduction = 1;}

            _robot.driveTrain.setPower(spin/reduction, spin/reduction, -(spin/reduction), -(spin/reduction));
        }
        else {
            int reduction = 2;
            if (_gamePad.right_bumper){reduction = 1;}

            x1 = _gamePad.left_stick_x;
            y1 = -_gamePad.left_stick_y;

            x2 = x1 * cosine45 - y1 * sine45;
            y2 = y1 * cosine45 + x1 * sine45;

            _robot.driveTrain.setPower(
                    x2/reduction
                    ,y2/reduction
                    ,y2/reduction
                    ,x2/reduction);
        }
    }
}