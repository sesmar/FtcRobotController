package Autonomous.Programs;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;

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

public class AutonomousProgramBlueA2 implements IAutonomousProgram{
	private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

	public AutonomousProgramBlueA2(CalamariRobot robot){
		steps.add(new AutonomousStepMoveFromStartingPosition(robot, "blue"));
		steps.add(new AutonomousStepLowerGuide(robot));
		steps.add(new AutonomousStepPositionChopChopForPlacement(robot));
		steps.add(new AutonomousStepDriveToBoard(robot, 68));
		steps.add(new AutonomousStepPositionLiftForPlacement(robot));
		steps.add(new AutonomousStepDropPixel(robot));
		steps.add(new AutonomousStepPositionArmForParking(robot));
		steps.add( new AutonomousStepPark(robot, "left"));
	}

	public void Run() throws InterruptedException {
		for (IAutonomousStep step : steps) {
			step.Execute();
		}
	}
}
