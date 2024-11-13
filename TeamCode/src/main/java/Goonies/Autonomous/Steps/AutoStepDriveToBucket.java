package Goonies.Autonomous.Steps;

import Goonies.Common.GooniesRobot;
public class AutoStepDriveToBucket implements IAutonomousStep{
    private final GooniesRobot _robot;

    public AutoStepDriveToBucket(GooniesRobot robot){
        _robot = robot;
    }

    @Override
    public void Execute()
    {
        double drivePower = .5;
        int inches = 12;
        _robot.driveTrain.driveforinches(inches,drivePower);
    }
}