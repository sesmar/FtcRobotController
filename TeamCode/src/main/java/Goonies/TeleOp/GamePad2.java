package Goonies.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import Goonies.Common.GooniesRobot;

public class GamePad2  implements IGamePad{
    private final GooniesRobot _robot;
    private final Gamepad _gamePad;

    public GamePad2(Gamepad gamePad, GooniesRobot robot){
        _gamePad = gamePad;
        _robot = robot;
    }

    public void HandleInput() {
        _robot.linearSlide.Movercycle(_gamePad.right_stick_y);

        if (_gamePad.a) {
            _robot.grabber.open();
        }

        if (_gamePad.b) {
            _robot.grabber.close();
        }

        if (_gamePad.x) {
            _robot.grabber.positionForGrabbing();
        }

        if (_gamePad.y) {
            _robot.grabber.positionForMoving();
        }

        if (_gamePad.right_bumper) {
            _robot.grabber.positionForDunk();
        }
    }
}