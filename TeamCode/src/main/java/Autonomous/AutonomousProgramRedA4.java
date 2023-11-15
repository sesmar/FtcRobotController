package Autonomous;

import Common.CalamariRobot;

public class AutonomousProgramRedA4  implements IAutonomousProgram{
    public CalamariRobot _robot;

    public AutonomousProgramRedA4(CalamariRobot robot){
        _robot = robot;
    }

    public void Run(){
        _robot.driveTrain.driveForInches(24, .75);
        _robot.driveTrain.turn(90, -.25);
        _robot.funnelCake.AutoCake("down");
        _robot.driveTrain.driveForInches(22, .75);

        _robot.liftArm.AutoArm("down");
        _robot.liftArm.AutoArm("up");
        _robot.funnelCake.AutoCake("up");

        _robot.driveTrain.turn(90, .25);
        _robot.driveTrain.driveForInches(23, -.75);
        _robot.driveTrain.turn(90, .25);
        _robot.driveTrain.driveForInches(21, -.75);
    }
}
