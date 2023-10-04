import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Common.CalamariRobot;

@TeleOp(name="Calamari: TeleOpMode", group="Linear OpMode")
public class CalamariTeleOpMode extends LinearOpMode {

	CalamariRobot robot = new CalamariRobot(this);

	@Override
	public void runOpMode() {
		double fortyFiveRads = -Math.PI/4;
		double cosine45 = Math.cos(fortyFiveRads);
		double sine45 = Math.sin(fortyFiveRads);

		robot.init();

		telemetry.addData("Status", "Initialized");
		telemetry.update();
		// Wait for the game to start (driver presses PLAY)
		waitForStart();

		// run until the end of the match (driver presses STOP)
		while (opModeIsActive()) {
			double x1; //left/right
			double y1; //forward/back
			double x2; //rotated 45 degrees counterclockwise
			double y2; //rotates 45 degress counterclockwise
			double spin  = gamepad1.right_stick_x;

			if (Math.abs(spin) > 0.1){
				robot.leftFrontDrive.setPower(spin);
				robot.leftBackDrive.setPower(spin);
				robot.rightFrontDrive.setPower(-spin);
				robot.rightBackDrive.setPower(-spin);

				telemetry.addData("spin", "%.2f", spin);
				telemetry.update();
			}
			else {
				x1 = gamepad1.left_stick_x;
				y1 = -gamepad1.left_stick_y;

				x2 = x1 * cosine45 - y1 * sine45;
				y2 = y1 * cosine45 + x1 * sine45;

				robot.leftFrontDrive.setPower(x2);
				robot.rightBackDrive.setPower(x2);

				robot.leftBackDrive.setPower(y2);
				robot.rightFrontDrive.setPower(y2);

				telemetry.addData("x1", "%.2f", x1);
				telemetry.addData("y1", "%.2f", y1);
				telemetry.addData("x2", "%.2f", x2);
				telemetry.addData("y2", "%.2f", y2);
				telemetry.update();
			}
		}
	}
}