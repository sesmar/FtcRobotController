package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepDriveToBoard  implements IAutonomousStep{
	private final CalamariRobot _robot;
	private int _inches = 0;

	public AutonomousStepDriveToBoard(CalamariRobot robot, int inches){
		_robot = robot;
		_inches = inches;
	}
	public void Execute()
	{
		double drivePower = CalamariRobot.drivePower;

		if(_inches < 0){
			_inches = -_inches;
			drivePower = -drivePower;
		}
		_robot.driveTrain.driveForInches(_inches, drivePower);

	}
}
