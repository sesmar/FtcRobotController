package Autonomous.Steps;

import java.util.Objects;

import Common.AllianceColor;
import Common.CalamariRobot;
import Common.SpikeMarkPosition;

public class AutonomousStepDriveToSpikeMark implements IAutonomousStep{
	private final CalamariRobot _robot;
	private final SpikeMarkPosition _spikeMark;
	private final AllianceColor _alliance;

	public AutonomousStepDriveToSpikeMark(CalamariRobot robot){
		_robot = robot;
		_spikeMark = robot.myEyes.getSpikeMark();
		_alliance = robot.myEyes.getAlliance();
	}
	public void Execute(){
		double turnPower = CalamariRobot.turnPower;
		int inchesToDrive = 24;

		if ((_alliance == AllianceColor.BLUE && _spikeMark == SpikeMarkPosition.LEFT)
			|| (_alliance == AllianceColor.RED && _spikeMark == SpikeMarkPosition.RIGHT)){
			turnPower = -turnPower;
		}

		if (_spikeMark == SpikeMarkPosition.CENTER) {
			inchesToDrive = 48;
		}

		_robot.driveTrain.driveForInches(inchesToDrive, CalamariRobot.drivePower);

		if (_spikeMark == SpikeMarkPosition.LEFT || _spikeMark == SpikeMarkPosition.RIGHT) {
			_robot.driveTrain.turn(90, turnPower);
		}
	}
}
