package Goonies.Autonomous.Steps;

import Goonies.Common.GooniesRobot;

public class AutoStepDunk implements IAutonomousStep{
    GooniesRobot _robot;

    public AutoStepDunk(GooniesRobot robot){
        _robot = robot;
    }

    @Override
    public void Execute() {
        _robot.linearSlide.drive();
        _robot.grabber.positionForDunk(true);
        _robot.grabber.open(true);
        _robot.grabber.positionForMoving(true);
        _robot.linearSlide.retract();
    }
}
