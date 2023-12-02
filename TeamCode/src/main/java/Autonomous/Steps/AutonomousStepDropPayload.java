package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepDropPayload implements IAutonomousStep{

	private final CalamariRobot _robot;

	public AutonomousStepDropPayload(CalamariRobot robot){
		_robot = robot;
	}
	public void Execute(){
		_robot.coinFlipper.Drop();
		double startTime = _robot.myOpMode.getRuntime();
		while((_robot.myOpMode.getRuntime() - startTime) < 1){
			//sleep(750);
		}
	}
}
