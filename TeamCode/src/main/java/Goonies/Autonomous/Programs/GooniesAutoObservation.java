package Goonies.Autonomous.Programs;

import java.util.ArrayList;

import Goonies.Autonomous.Steps.AutoJustGoRight;
import Goonies.Autonomous.Steps.AutoStepDriveForward;
import Goonies.Autonomous.Steps.AutoStepDriveSideways;
import Goonies.Autonomous.Steps.AutoStepTurn;
import Goonies.Autonomous.Steps.IAutonomousStep;
import Goonies.Common.GooniesRobot;

public class GooniesAutoObservation implements IAutonomousProgram {
    private final ArrayList<IAutonomousStep> steps = new ArrayList<>();
    private final GooniesRobot _robot;

    public GooniesAutoObservation(GooniesRobot robot){
        _robot = robot;
        steps.add(new AutoStepDriveForward(_robot, 6));
        steps.add(new AutoStepTurn(_robot, 90));
        steps.add(new AutoStepDriveForward(_robot, 16));
        steps.add(new AutoStepDriveSideways(_robot, -45));
        steps.add(new AutoStepDriveForward(_robot, 10));
        steps.add(new AutoStepDriveSideways(_robot, 47));
        steps.add(new AutoStepDriveSideways(_robot, -47));
        steps.add(new AutoStepDriveForward(_robot, 6));
        steps.add(new AutoStepDriveSideways(_robot, 47));

    }

    public void Run() {
        for (IAutonomousStep step : steps) {
            step.Execute();
        }
    }
}

