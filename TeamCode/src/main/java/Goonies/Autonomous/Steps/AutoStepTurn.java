package Goonies.Autonomous.Steps;
import Goonies.Common.GooniesRobot;
public class AutoStepTurn implements IAutonomousStep {
    private final GooniesRobot _robot;
    private int _degrees = 0;
    public AutoStepTurn(GooniesRobot robot, int degrees ){
        _robot = robot;
        _degrees = degrees;
    }

    @Override
    public void Execute()
    {
        double turnPower = _robot.turnPower;
        if(_degrees < 0){
            _degrees = -_degrees;
            turnPower = -turnPower;
        }

        _robot.driveTrain.turn(_degrees, turnPower);
    }
}
