package Autonomous.Steps;

import static java.lang.Thread.sleep;

import Common.CalamariRobot;

public class AutonomousStepDropPixel implements IAutonomousStep{
	private final CalamariRobot _robot;

	public AutonomousStepDropPixel(CalamariRobot robot){
		_robot = robot;
	}

	public void Execute() throws InterruptedException {
		_robot.chopChop.Close();

		double startTime = _robot.myOpMode.getRuntime();
		while((_robot.myOpMode.getRuntime() - startTime) < 1){
			//sleep(750);
		}
	}
}
