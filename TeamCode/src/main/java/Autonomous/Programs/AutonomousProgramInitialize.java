package Autonomous.Programs;

import java.util.ArrayList;

import Autonomous.Steps.AutonomousStepDriveToBoard;
import Autonomous.Steps.AutonomousStepLowerGuide;
import Autonomous.Steps.AutonomousStepPositionChopChopForPlacement;
import Autonomous.Steps.AutonomousStepPositionLiftForPlacement;
import Autonomous.Steps.IAutonomousStep;
import Common.CalamariRobot;

public class AutonomousProgramInitialize implements IAutonomousProgram{
	private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

    public AutonomousProgramInitialize(CalamariRobot robot){
        steps.add(new AutonomousStepDriveToBoard(robot, 24));
        steps.add(new AutonomousStepLowerGuide(robot));
        steps.add(new AutonomousStepPositionChopChopForPlacement(robot));
        steps.add(new AutonomousStepPositionLiftForPlacement(robot));
    }

    public void Run() throws InterruptedException {
        for (IAutonomousStep step : steps) {
            step.Execute();
        }
    }
}
