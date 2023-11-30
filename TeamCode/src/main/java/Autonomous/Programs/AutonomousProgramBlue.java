package Autonomous.Programs;

import java.util.ArrayList;

import Autonomous.Steps.AutonomousStepDriveToSpikeMark;
import Autonomous.Steps.IAutonomousStep;
import Common.CalamariRobot;
import Common.StartingBlock;

public class AutonomousProgramBlue implements IAutonomousProgram{
	private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

	public AutonomousProgramBlue(CalamariRobot robot, StartingBlock startingBlock){
		steps.add(new AutonomousStepDriveToSpikeMark(robot));
	}

	public void Run() throws InterruptedException {
		for (IAutonomousStep step : steps) {
			step.Execute();
		}
	}
}
