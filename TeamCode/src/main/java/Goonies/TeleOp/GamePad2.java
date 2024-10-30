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
        if (_gamePad.x){
            _robot.lineSlide.Movercycle(.85);
        }else if (_gamePad.y){
            _robot.lineSlide.Movercycle(-.85);
        }else{
            _robot.lineSlide.Movercycle(0);
        }



        if (_gamePad.b){
            _robot.climber.poweroffrendship(.85);
        }else if (_gamePad.a){
            _robot.climber.poweroffrendship(-.85);
        }else{
            _robot.climber.poweroffrendship(0);
        }

        if (_gamePad.left_bumper){
            _robot.intake.Input();
        } else if (_gamePad.right_bumper){
            _robot.intake.Output();
        }
        else{
            _robot.intake.Stop();
        }
//WE CLIMB WITH THE POWER OF FRIENDSHIP!!!!!!!!!
        //if b then what the sigma
//neurolink a move up
    }
}