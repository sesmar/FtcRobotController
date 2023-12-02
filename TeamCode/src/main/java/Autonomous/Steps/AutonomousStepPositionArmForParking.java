package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepPositionArmForParking implements IAutonomousStep{
	private final CalamariRobot _robot;

	public AutonomousStepPositionArmForParking(CalamariRobot robot){
		_robot = robot;
	}

	public void Execute() throws InterruptedException{
		_robot.liftArm.AutoArm("down");
		_robot.funnelCake.AutoCake("up");
	}

}
