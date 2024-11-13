package Goonies.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import Goonies.Common.GooniesRobot;
import Goonies.Common.LineSlide;

public class GamePad2  implements IGamePad{
    private static final double fortyFiveRads = -Math.PI/4;
    private static final double cosine45 = Math.cos(fortyFiveRads);
    private static final double sine45 = Math.sin(fortyFiveRads);
    private final GooniesRobot _robot;
    private final Gamepad _gamePad;

    public GamePad2(Gamepad gamePad, GooniesRobot robot){
        _gamePad = gamePad;
        _robot = robot;
    }
    public void HandleInput(){
        _robot.lineSlide.Movercycle(_gamePad.right_stick_y);
        //_robot.intake.Move(_gamePad.left_stick_y/3);

        /*
        if (_gamePad.right_bumper){
            _robot.climber.poweroffrendship(.85);
        }else if (_gamePad.left_bumper){
            _robot.climber.poweroffrendship(-.85);
        }else{
            _robot.climber.poweroffrendship(0);
        }
*/

        /*
        if (_gamePad.a) {
            _robot.intake.Input();
        }else if (_gamePad.b) {
            _robot.intake.Output();
        }else {
            _robot.intake.Stop();
        }
*/
        }
//WE CLIMB WITH THE POWER OF FRIENDSHIP!!!!!!!!!
       // skibidi toilet will b mine!!!!!!

}