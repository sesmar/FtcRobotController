package Autonomous.Steps;

import java.util.Objects;

import Common.CalamariRobot;

public class AutonomousStepPark implements IAutonomousStep{
	private final CalamariRobot _robot;
	private String _side = "left";
	public AutonomousStepPark(CalamariRobot robot, String side){
		_robot = robot;
		_side = side;
	}

	public void Execute() {
		double turnPower = CalamariRobot.turnPower;

		if (Objects.equals(_side, "left")){
			turnPower = -turnPower;
		}

		_robot.driveTrain.turn(90, turnPower);
		_robot.driveTrain.driveForInches(22, -CalamariRobot.drivePower);
		_robot.driveTrain.turn(90, turnPower);
		_robot.driveTrain.driveForInches(23, -CalamariRobot.drivePower);
	}
}
