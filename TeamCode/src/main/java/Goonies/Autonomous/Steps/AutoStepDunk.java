package Goonies.Autonomous.Steps;

import Goonies.Common.GooniesRobot;

public class AutoStepDunk implements IAutonomousStep{
    GooniesRobot _robot;

    public AutoStepDunk(GooniesRobot robot){
        _robot = robot;
    }

    @Override
    public void Execute() {
        _robot.lineSlide.Drive(100);
    }
}
