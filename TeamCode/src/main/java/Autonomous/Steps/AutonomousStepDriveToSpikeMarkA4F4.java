package Autonomous.Steps;

import Common.AllianceColor;
import Common.CalamariRobot;
import Common.SpikeMarkPosition;

public class AutonomousStepDriveToSpikeMarkA4F4 implements IAutonomousStep{
	private final CalamariRobot _robot;
	private final SpikeMarkPosition _spikeMark;
	private final AllianceColor _alliance;

	public AutonomousStepDriveToSpikeMarkA4F4(CalamariRobot robot, AllianceColor alliance, SpikeMarkPosition spikeMark){
		_robot = robot;
		_spikeMark = spikeMark;
		_alliance = alliance;
	}
	public void Execute(){
		double turnPower = CalamariRobot.turnPower;
		int inchesToDrive = 26;

		if (_spikeMark == SpikeMarkPosition.LEFT){
			turnPower = -turnPower;
		}

		if (_spikeMark == SpikeMarkPosition.CENTER) {
			inchesToDrive = 25;
		}

		_robot.driveTrain.driveForInches(inchesToDrive, CalamariRobot.drivePower);

		if (_spikeMark == SpikeMarkPosition.LEFT || _spikeMark == SpikeMarkPosition.RIGHT) {
			_robot.driveTrain.turn(90, turnPower);
		} else if(_spikeMark == SpikeMarkPosition.CENTER){
			_robot.driveTrain.turn(180,turnPower);
		}

	}
}
