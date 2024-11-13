package Goonies.Autonomous.Programs;

import java.util.ArrayList;

import Goonies.Autonomous.Steps.AutoStepTurn;
import Goonies.Autonomous.Steps.IAutonomousStep;
import Goonies.Autonomous.Steps.AutoStepDriveForward;
import Goonies.Autonomous.Steps.AutoStepDriveSideways;
import Goonies.Common.GooniesRobot;
public class GooniesAutoDunk implements IAutonomousProgram {

    private final ArrayList<IAutonomousStep> steps = new ArrayList<>();

    private final GooniesRobot _robot;

    public GooniesAutoDunk(GooniesRobot robot) {
        _robot = robot;
        steps.add(new AutoStepDriveForward(_robot,31));
        /*steps.add(new);// bring the lineslide up
        steps.add(new);//score
        steps.add(new);//bring line slide down
        steps.add(new);//move back to the human player zone
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);
        steps.add(new);*/
    }

    public void Run() {
        for (IAutonomousStep step : steps) {
            step.Execute();

        }
    }
}





























