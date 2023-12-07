package Autonomous.Steps;

import Common.CalamariRobot;

public class AutonomousStepDropPayload implements IAutonomousStep{

	private final CalamariRobot _robot;
	private final int _egg;

	public AutonomousStepDropPayload(CalamariRobot robot,int egg){
		_robot = robot;
		_egg = egg;
	}
	public void Execute(){
		_robot.eggDropper.Drop(_egg);
		double startTime = _robot.myOpMode.getRuntime();
		while((_robot.myOpMode.getRuntime() - startTime) < 1){
			//sleep(750);
		}
	}
}
