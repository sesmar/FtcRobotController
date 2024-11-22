package Goonies.Autonomous.Steps;

import Goonies.Common.GooniesRobot;

public class AutoStepDriveBackwards implements IAutonomousStep {
    GooniesRobot _robot;
    int _inches = 0;

    public AutoStepDriveBackwards(GooniesRobot robot, int inches) {
        _robot = robot;
        _inches = inches;
    }

    @Override
    public void Execute() {
        _robot.driveTrain.driveforinches(_inches, -_robot.drivePower);
    }
}
