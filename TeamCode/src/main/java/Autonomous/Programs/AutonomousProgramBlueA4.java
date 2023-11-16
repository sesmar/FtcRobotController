package Autonomous.Programs;

import Autonomous.Steps.AutonomousStepDriveToBoard;
import Autonomous.Steps.AutonomousStepDropPixel;
import Autonomous.Steps.AutonomousStepLowerGuide;
import Autonomous.Steps.AutonomousStepMoveFromStartingPosition;
import Autonomous.Steps.AutonomousStepPark;
import Autonomous.Steps.AutonomousStepPositionArmForParking;
import Autonomous.Steps.AutonomousStepPositionArmForPlacement;
import Autonomous.Steps.IAutonomousStep;
import Common.CalamariRobot;

public class AutonomousProgramBlueA4 implements IAutonomousProgram{
	private final int numberOfSteps = 7;
	private final IAutonomousStep[] steps = new IAutonomousStep[numberOfSteps];

	public AutonomousProgramBlueA4(CalamariRobot robot){
		steps[0] = new AutonomousStepMoveFromStartingPosition(robot, "blue");
		steps[1] = new AutonomousStepLowerGuide(robot);
		steps[2] = new AutonomousStepDriveToBoard(robot, 21);
		steps[3] = new AutonomousStepPositionArmForPlacement(robot);
		steps[4] = new AutonomousStepDropPixel(robot);
		steps[5] = new AutonomousStepPositionArmForParking(robot);
		steps[6] = new AutonomousStepPark(robot, "right");
	}

	public void Run() throws InterruptedException {
		for (IAutonomousStep step : steps) {
			step.Execute();
		}
	}
}
