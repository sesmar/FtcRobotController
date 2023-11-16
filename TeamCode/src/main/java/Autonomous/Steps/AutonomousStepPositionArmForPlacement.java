package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepPositionArmForPlacement implements IAutonomousStep{
	private final CalamariRobot _robot;

	public AutonomousStepPositionArmForPlacement(CalamariRobot robot){
		_robot = robot;
	}

	public void Execute(){
		_robot.chopChop.Open();
		_robot.liftArm.AutoArm("down");
		_robot.chopChop.CorrectChop("up");
	}
}
