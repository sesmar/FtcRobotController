package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepTurnRobot implements IAutonomousStep{
	private final CalamariRobot _robot;
	private int _degrees = 0;

	public AutonomousStepTurnRobot(CalamariRobot robot, int degrees){
		_robot = robot;
		_degrees = degrees;
	}
	public void Execute()
	{
		double turnPower = CalamariRobot.turnPower;

		if(_degrees < 0){
			_degrees = -_degrees;
			turnPower = -turnPower;
		}

		_robot.driveTrain.turn(_degrees, turnPower);
	}
}
