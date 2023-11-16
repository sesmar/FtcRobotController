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

public class AutonomousProgramRedF4 implements IAutonomousProgram{
	private final int numberOfSteps = 7;
	private final IAutonomousStep[] steps = new IAutonomousStep[numberOfSteps];

    public AutonomousProgramRedF4(CalamariRobot robot){
		steps[0] = new AutonomousStepMoveFromStartingPosition(robot, "red");
		steps[1] = new AutonomousStepLowerGuide(robot);
		steps[2] = new AutonomousStepDriveToBoard(robot, 21);
		steps[3] = new AutonomousStepPositionArmForPlacement(robot);
		steps[4] = new AutonomousStepDropPixel(robot);
		steps[5] = new AutonomousStepPositionArmForParking(robot);
		steps[6] = new AutonomousStepPark(robot, "left");
    }

    public void Run() throws InterruptedException {

		for (IAutonomousStep step : steps) {
			step.Execute();
		}

        //_robot.driveTrain.driveForInches(24, drivePower);
        //_robot.driveTrain.turn(90, -turnPower);
		//_robot.funnelCake.AutoCake("down");
        //_robot.driveTrain.driveForInches(21, drivePower);

        //_robot.chopChop.Open();
        //_robot.liftArm.AutoArm("down");
        //_robot.chopChop.CorrectChop("up");
        //_robot.chopChop.Close();
        //sleep(750);

        //_robot.liftArm.AutoArm("up");
        //_robot.funnelCake.AutoCake("up");

        //_robot.driveTrain.turn(90, turnPower);
        //_robot.driveTrain.driveForInches(22, -drivePower);
        //_robot.driveTrain.turn(90, turnPower);
        //_robot.driveTrain.driveForInches(23, -drivePower);
    }
}
