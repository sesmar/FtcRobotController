package Goonies.Autonomous.Steps;

import Goonies.Common.GooniesRobot;

public class AutoStepDriveSideways implements IAutonomousStep{
    GooniesRobot _robot;
    int _inches = 0;

    public AutoStepDriveSideways(GooniesRobot robot, int inches){
        _robot = robot;
        _inches = inches;
    }

    @Override
    public void Execute() {
        _robot.driveTrain.driveSidewaysForInches(_inches, _robot.drivePower);
    }
}
