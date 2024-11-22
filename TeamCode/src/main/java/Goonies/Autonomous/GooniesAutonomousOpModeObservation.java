package Goonies.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Goonies.Autonomous.Programs.GooniesAutoObservation;
import Goonies.Autonomous.Programs.IAutonomousProgram;
import Goonies.Common.GooniesRobot;
import Goonies.Common.IRobot;

@Autonomous(name="Goonies: AutonomousOpModeObservation", group="Goonies", preselectTeleOp = "Goonies: TeleOpMode")
public class GooniesAutonomousOpModeObservation extends LinearOpMode {
	IRobot _robot = new GooniesRobot(this);
	IAutonomousProgram _program;

	@Override
	public void runOpMode() {
		if (_robot != null) {
			_robot.Initialize(this.hardwareMap);
		} else {
			telemetry.addData("Robot", "Robot was not Instantiated");
			telemetry.update();
		}

		_program = new GooniesAutoObservation((GooniesRobot)_robot);

		telemetry.addData("Status", "Autonomous Initialized");
		telemetry.update();

		waitForStart();

		if (_program != null) {
			_program.Run();
		} else {
			telemetry.addData("Program", "No AutonmousProgram Instantiated");
			telemetry.update();
		}
	}
}
