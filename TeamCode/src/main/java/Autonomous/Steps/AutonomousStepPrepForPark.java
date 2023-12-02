package Autonomous.Steps;

import android.provider.CalendarContract;

import Common.AllianceColor;
import Common.CalamariRobot;
import Common.SpikeMarkPosition;

public class AutonomousStepPrepForPark implements IAutonomousStep{
	private final CalamariRobot _robot;
	private final SpikeMarkPosition _spikeMark;
	private final AllianceColor _alliance;

	public AutonomousStepPrepForPark(CalamariRobot robot, AllianceColor alliance, SpikeMarkPosition spikeMark){
		_robot = robot;
		_spikeMark = spikeMark;
		_alliance = alliance;
	}
	public void Execute(){
		double drivePower = CalamariRobot.drivePower;

		if(_spikeMark == SpikeMarkPosition.CENTER){
			double turnPower = CalamariRobot.turnPower;
			if (_alliance == AllianceColor.BLUE){
				turnPower = -turnPower;
			}

			_robot.driveTrain.turn(90, turnPower);
		}else {
			if(_spikeMark == SpikeMarkPosition.RIGHT){
				drivePower = -drivePower;
			}
			_robot.driveTrain.driveSidewaysForInches(26, drivePower);
		}

		if ((_alliance == AllianceColor.BLUE && _spikeMark == SpikeMarkPosition.RIGHT)
			|| (_alliance == AllianceColor.RED && _spikeMark == SpikeMarkPosition.LEFT)){
			_robot.driveTrain.turn(180, CalamariRobot.turnPower);
		}
	}
}
