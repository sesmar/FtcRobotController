package Autonomous.Programs;

import java.util.ArrayList;

import Autonomous.Steps.AutonomousStepDriveToBoard;
import Autonomous.Steps.AutonomousStepDriveToSpikeMarkA2F2;
import Autonomous.Steps.AutonomousStepDriveToSpikeMarkA4F4;
import Autonomous.Steps.AutonomousStepDropPayload;
import Autonomous.Steps.AutonomousStepLowerGuide;
import Autonomous.Steps.AutonomousStepPositionArmForParking;
import Autonomous.Steps.AutonomousStepPositionChopChopForPlacement;
import Autonomous.Steps.AutonomousStepPrepForParkA2F2;
import Autonomous.Steps.AutonomousStepPrepForParkA4F4;
import Autonomous.Steps.AutonomousStepTurnRobot;
import Autonomous.Steps.IAutonomousStep;
import Common.AllianceColor;
import Common.CalamariRobot;
import Common.StartingBlock;

public class AutonomousProgramBlue implements IAutonomousProgram{
	private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

	public AutonomousProgramBlue(CalamariRobot robot, StartingBlock startingBlock){
		if (startingBlock == StartingBlock.A2 || startingBlock == StartingBlock.F2) {
			steps.add(new AutonomousStepDriveToSpikeMarkA2F2(robot, AllianceColor.BLUE, robot.myEyes.getSpikeMark()));
		}else{
			steps.add(new AutonomousStepDriveToSpikeMarkA4F4(robot, AllianceColor.BLUE, robot.myEyes.getSpikeMark()));
		}

		steps.add(new AutonomousStepDropPayload(robot,1));

		if (startingBlock == StartingBlock.A2 || startingBlock == StartingBlock.F2) {
			steps.add(new AutonomousStepPrepForParkA2F2(robot, AllianceColor.BLUE, robot.myEyes.getSpikeMark()));
			steps.add(new AutonomousStepLowerGuide(robot));
			steps.add(new AutonomousStepPositionChopChopForPlacement(robot));
			steps.add(new AutonomousStepDriveToBoard(robot, -72));

		}
		else{
			steps.add(new AutonomousStepPrepForParkA4F4(robot, AllianceColor.BLUE, robot.myEyes.getSpikeMark()));
			steps.add(new AutonomousStepDriveToBoard(robot, -24));
			steps.add(new AutonomousStepLowerGuide(robot));
			steps.add(new AutonomousStepPositionChopChopForPlacement(robot));
		}

		steps.add(new AutonomousStepPositionArmForParking(robot));

		if (startingBlock == StartingBlock.A2 || startingBlock == StartingBlock.F2) {
			steps.add(new AutonomousStepTurnRobot(robot, 40));
		}

		steps.add(new AutonomousStepDriveToBoard(robot, -6));
		steps.add(new AutonomousStepDropPayload(robot,2));
	}

	public void Run() throws InterruptedException {
		for (IAutonomousStep step : steps) {
			step.Execute();
		}
	}
}
