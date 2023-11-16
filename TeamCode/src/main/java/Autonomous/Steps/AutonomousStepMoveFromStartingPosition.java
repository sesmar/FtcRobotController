package Autonomous.Steps;

import java.util.Objects;

import Common.CalamariRobot;

public class AutonomousStepMoveFromStartingPosition  implements IAutonomousStep{
	private final CalamariRobot _robot;
	private final String _direction;

	public AutonomousStepMoveFromStartingPosition(CalamariRobot robot, String direction){
		_robot = robot;
		_direction = direction;
	}
	public void Execute(){
		double turnPower = CalamariRobot.turnPower;

		if (Objects.equals(_direction, "red")){
			turnPower = -turnPower;
		}
		_robot.driveTrain.driveForInches(24, CalamariRobot.drivePower);
		_robot.driveTrain.turn(90, turnPower);
	}
}
