package Autonomous.Programs;

import Autonomous.Steps.AutonomousStepDriveToBoard;
import Autonomous.Steps.AutonomousStepDropPixel;
import Autonomous.Steps.AutonomousStepLowerGuide;
import Autonomous.Steps.AutonomousStepMoveFromStartingPosition;
import Autonomous.Steps.AutonomousStepPark;
import Autonomous.Steps.AutonomousStepPositionArmForParking;
import Autonomous.Steps.AutonomousStepPositionArmForPlacement;
import Autonomous.Steps.AutonomousStepPositionChopChopForPlacement;
import Autonomous.Steps.AutonomousStepPositionLiftForPlacement;
import Autonomous.Steps.IAutonomousStep;
import Common.CalamariRobot;

public class AutonomousProgramRedF4 implements IAutonomousProgram{
	private final int numberOfSteps = 8;
	private final IAutonomousStep[] steps = new IAutonomousStep[numberOfSteps];

    public AutonomousProgramRedF4(CalamariRobot robot){
		steps[0] = new AutonomousStepMoveFromStartingPosition(robot, "red");
		steps[1] = new AutonomousStepLowerGuide(robot);
		steps[2] = new AutonomousStepPositionChopChopForPlacement(robot);
		steps[3] = new AutonomousStepDriveToBoard(robot, 22);
		steps[4] = new AutonomousStepPositionLiftForPlacement(robot);
		steps[5] = new AutonomousStepDropPixel(robot);
		steps[6] = new AutonomousStepPositionArmForParking(robot);
		steps[7] = new AutonomousStepPark(robot, "left");
    }

    public void Run() throws InterruptedException {

		for (IAutonomousStep step : steps) {
			step.Execute();
		}
    }
}
