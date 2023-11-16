package Autonomous;

import static java.lang.Thread.sleep;

import Common.CalamariRobot;

public class AutonomousProgramRedF4 implements IAutonomousProgram{
    public CalamariRobot _robot;

    public AutonomousProgramRedF4(CalamariRobot robot){
        _robot = robot;
    }

    public void Run() throws InterruptedException {
        double turnPower = .4;
        double drivePower = .75;

        _robot.driveTrain.driveForInches(24, drivePower);
        _robot.driveTrain.turn(90, -turnPower);
        _robot.funnelCake.AutoCake("down");
        _robot.driveTrain.driveForInches(21, drivePower);

        _robot.chopChop.Open();
        _robot.liftArm.AutoArm("down");
        _robot.chopChop.CorrectChop("up");
        _robot.chopChop.Close();

        sleep(750);

        //_robot.chopChop.CorrectChop("down");
        _robot.liftArm.AutoArm("up");
        _robot.funnelCake.AutoCake("up");

        _robot.driveTrain.turn(90, turnPower);
        _robot.driveTrain.driveForInches(22, -drivePower);
        _robot.driveTrain.turn(90, turnPower);
        _robot.driveTrain.driveForInches(23, -drivePower);


    }
}
