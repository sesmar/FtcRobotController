package Autonomous.Programs;

import java.util.ArrayList;

import Autonomous.Steps.AutonomousStepDriveToBoard;
import Autonomous.Steps.AutonomousStepDriveToSpikeMark;
import Autonomous.Steps.AutonomousStepDropPayload;
import Autonomous.Steps.AutonomousStepLowerGuide;
import Autonomous.Steps.AutonomousStepPositionArmForParking;
import Autonomous.Steps.AutonomousStepPositionChopChopForPlacement;
import Autonomous.Steps.AutonomousStepPrepForPark;
import Autonomous.Steps.IAutonomousStep;
import Common.AllianceColor;
import Common.CalamariRobot;
import Common.StartingBlock;

public class AutonomousProgramRed implements IAutonomousProgram{
	private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

	public AutonomousProgramRed(CalamariRobot robot, StartingBlock startingBlock){
		steps.add(new AutonomousStepDriveToSpikeMark(robot, AllianceColor.RED, robot.myEyes.getSpikeMark()));
		steps.add(new AutonomousStepDropPayload(robot));
		steps.add(new AutonomousStepPrepForPark(robot, AllianceColor.RED, robot.myEyes.getSpikeMark()));


		if (startingBlock == StartingBlock.A2 || startingBlock == StartingBlock.F2) {
			steps.add(new AutonomousStepLowerGuide(robot));
			steps.add(new AutonomousStepPositionChopChopForPlacement(robot));
			steps.add(new AutonomousStepDriveToBoard(robot, -72));
		}
		else{
			steps.add(new AutonomousStepDriveToBoard(robot, -24));
			steps.add(new AutonomousStepLowerGuide(robot));
			steps.add(new AutonomousStepPositionChopChopForPlacement(robot));
		}

		steps.add(new AutonomousStepPositionArmForParking(robot));
		steps.add(new AutonomousStepDriveToBoard(robot, -12));
	}

	public void Run() throws InterruptedException {
		for (IAutonomousStep step : steps) {
			step.Execute();
		}
	}
}
