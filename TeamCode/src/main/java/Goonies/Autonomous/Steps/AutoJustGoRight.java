package Goonies.Autonomous.Steps;

import Goonies.Common.GooniesRobot;

public class AutoJustGoRight implements IAutonomousStep {
    GooniesRobot _robot;
    int _seconds = 0;

    public AutoJustGoRight(GooniesRobot robot, int seconds) {
        _robot = robot;
        _seconds = seconds;
    }

    @Override
    public void Execute() {
        _robot.driveTrain.driveForSeconds(_seconds, _robot.drivePower);
    }
}
