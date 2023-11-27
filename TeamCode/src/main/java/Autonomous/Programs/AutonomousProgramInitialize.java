package Autonomous.Programs;

import Autonomous.Steps.AutonomousStepDriveToBoard;
import Autonomous.Steps.AutonomousStepDropPixel;
import Autonomous.Steps.AutonomousStepLowerGuide;
import Autonomous.Steps.AutonomousStepMoveFromStartingPosition;
import Autonomous.Steps.AutonomousStepPark;
import Autonomous.Steps.AutonomousStepPositionArmForParking;
import Autonomous.Steps.AutonomousStepPositionChopChopForPlacement;
import Autonomous.Steps.AutonomousStepPositionLiftForPlacement;
import Autonomous.Steps.IAutonomousStep;
import Common.CalamariRobot;

public class AutonomousProgramInitialize implements IAutonomousProgram{
    private final int numberOfSteps = 4;
    private final IAutonomousStep[] steps = new IAutonomousStep[numberOfSteps];

    public AutonomousProgramInitialize(CalamariRobot robot){
        steps[0] = new AutonomousStepDriveToBoard(robot, 24);
        steps[1] = new AutonomousStepLowerGuide(robot);
        steps[2] = new AutonomousStepPositionChopChopForPlacement(robot);
        steps[3] = new AutonomousStepPositionLiftForPlacement(robot);
    }

    public void Run() throws InterruptedException {
        for (IAutonomousStep step : steps) {
            step.Execute();
        }
    }
}
