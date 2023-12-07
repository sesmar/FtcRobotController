package Autonomous.Steps;

import Common.AllianceColor;
import Common.CalamariRobot;
import Common.SpikeMarkPosition;

public class AutonomousStepPrepForParkA4F4 implements IAutonomousStep{
	private final CalamariRobot _robot;
	private final SpikeMarkPosition _spikeMark;
	private final AllianceColor _alliance;

	public AutonomousStepPrepForParkA4F4(CalamariRobot robot, AllianceColor alliance, SpikeMarkPosition spikeMark){
		_robot = robot;
		_spikeMark = spikeMark;
		_alliance = alliance;
	}
	public void Execute(){
		double drivePower = CalamariRobot.drivePower;

		if(_spikeMark == SpikeMarkPosition.CENTER){
			double turnPower = CalamariRobot.turnPower;
			if (_alliance == AllianceColor.RED){
				turnPower = -turnPower;
				//drivePower = -drivePower;
			}
			_robot.driveTrain.driveForInches(24,CalamariRobot.drivePower);
			_robot.driveTrain.turn(90, turnPower);
		}else {
			if(_spikeMark == SpikeMarkPosition.LEFT){
				drivePower = -drivePower;
			}
			_robot.driveTrain.driveSidewaysForInches(24, drivePower);
		}

		if ((_alliance == AllianceColor.BLUE && _spikeMark == SpikeMarkPosition.RIGHT)
			|| (_alliance == AllianceColor.RED && _spikeMark == SpikeMarkPosition.LEFT)){
			_robot.driveTrain.turn(178, CalamariRobot.turnPower);
		}
	}
}
