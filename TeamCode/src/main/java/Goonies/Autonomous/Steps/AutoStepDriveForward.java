package Goonies.Autonomous.Steps;

import Goonies.Autonomous.Programs.GooniesAutoRed1;
import Goonies.Common.GooniesRobot;

public class AutoStepDriveForward implements IAutonomousStep {
    GooniesRobot _robot;
    int _inches = 0;

    public AutoStepDriveForward(GooniesRobot robot, int inches) {
        _robot = robot;
        _inches = inches;
    }

    @Override
    public void Execute() {
        _robot.driveTrain.driveforinches(_inches, _robot.drivePower);
    }
}
