package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepPositionChopChopForPlacement implements IAutonomousStep{
	private final CalamariRobot _robot;

	public AutonomousStepPositionChopChopForPlacement(CalamariRobot robot){
		_robot = robot;
	}

	public void Execute(){
		_robot.chopChop.Open();
		_robot.chopChop.CorrectChop("up");
	}
}
