package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepLowerGuide implements IAutonomousStep{
	private final CalamariRobot _robot;

	public AutonomousStepLowerGuide(CalamariRobot robot){
		_robot = robot;
	}
	public void Execute(){
		_robot.funnelCake.AutoCake("down");
	}

}
