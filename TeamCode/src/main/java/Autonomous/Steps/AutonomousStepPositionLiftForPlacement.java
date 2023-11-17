package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepPositionLiftForPlacement implements IAutonomousStep{
	private final CalamariRobot _robot;

	public AutonomousStepPositionLiftForPlacement(CalamariRobot robot){
		_robot = robot;
	}

	public void Execute(){
		_robot.liftArm.AutoArm("down");
	}
}
