package Autonomous.Programs;

import java.util.ArrayList;

import Autonomous.Steps.AutonomousStepDriveToSpikeMark;
import Autonomous.Steps.IAutonomousStep;
import Common.CalamariRobot;
import Common.StartingBlock;

public class AutonomousProgramRed implements IAutonomousProgram{
	private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

	public AutonomousProgramRed(CalamariRobot robot, StartingBlock startingBlock){
		steps.add(new AutonomousStepDriveToSpikeMark(robot));
	}

	public void Run() throws InterruptedException {
		for (IAutonomousStep step : steps) {
			step.Execute();
		}
	}
}
