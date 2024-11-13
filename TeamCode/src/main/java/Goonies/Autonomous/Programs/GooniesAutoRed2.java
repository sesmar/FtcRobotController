package Goonies.Autonomous.Programs;

import java.util.ArrayList;

import Goonies.Autonomous.Steps.AutoStepTurn;
import Goonies.Autonomous.Steps.IAutonomousStep;
import Goonies.Autonomous.Steps.AutoStepDriveForward;
import Goonies.Autonomous.Steps.AutoStepDriveSideways;
import Goonies.Common.GooniesRobot;

public class GooniesAutoRed2 implements IAutonomousProgram {

    private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

    private final GooniesRobot _robot;

    public GooniesAutoRed2(GooniesRobot robot) {
        _robot = robot;
        steps.add(new AutoStepDriveForward(_robot, 6));
        steps.add(new AutoStepTurn(_robot, -90));
        steps.add(new AutoStepDriveForward(_robot, 16));
        steps.add(new AutoStepDriveSideways(_robot, 45));
        steps.add(new AutoStepDriveForward(_robot, 12));
        steps.add(new AutoStepDriveSideways(_robot, -49));
        steps.add(new AutoStepDriveSideways(_robot, 49));
        steps.add(new AutoStepDriveForward(_robot, 10));
        steps.add(new AutoStepDriveSideways(_robot, 49));

    }

    public void Run() {
        for (IAutonomousStep step : steps) {
            step.Execute();

        }
    }
}