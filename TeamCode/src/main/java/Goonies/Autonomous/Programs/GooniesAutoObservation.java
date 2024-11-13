package Goonies.Autonomous.Programs;

import java.util.ArrayList;

import Goonies.Autonomous.Steps.AutoJustGoRight;
import Goonies.Autonomous.Steps.AutoStepDriveForward;
import Goonies.Autonomous.Steps.AutoStepDriveSideways;
import Goonies.Autonomous.Steps.IAutonomousStep;
import Goonies.Common.GooniesRobot;

public class GooniesAutoObservation implements IAutonomousProgram {
    private final ArrayList<IAutonomousStep> steps = new ArrayList<>();
    private final GooniesRobot _robot;

    public GooniesAutoObservation(GooniesRobot robot){
        _robot = robot;
        steps.add(new AutoStepDriveForward(_robot, 3));
        steps.add(new AutoStepDriveSideways(_robot, 24));
    }

    public void Run() {
        for (IAutonomousStep step : steps) {
            step.Execute();
        }
    }
}

