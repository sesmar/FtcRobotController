import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Common.CalamariRobot;

@TeleOp(name="Calamari: TeleOpMode", group="Linear OpMode")
public class CalamariTeleOpMode extends LinearOpMode {

	private static final double fortyFiveRads = -Math.PI/4;
	private static final double cosine45 = Math.cos(fortyFiveRads);
	private static final double sine45 = Math.sin(fortyFiveRads);

	CalamariRobot robot = new CalamariRobot(this);

	@Override
	public void runOpMode() {

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
			double y2; //rotates 45 degrees counterclockwise
			double spin  = gamepad1.right_stick_x;

			if (Math.abs(spin) > 0.1){
				robot.driveTrain.setPower(spin, spin, -spin, -spin);

				telemetry.addData("spin", "%.2f", spin);
				telemetry.update();
			}
			else {
				x1 = gamepad1.left_stick_x;
				y1 = -gamepad1.left_stick_y;

				x2 = x1 * cosine45 - y1 * sine45;
				y2 = y1 * cosine45 + x1 * sine45;

				robot.driveTrain.setPower(x2, y2, y2, x2);

				telemetry.addData("x1", "%.2f", x1);
				telemetry.addData("y1", "%.2f", y1);
				telemetry.addData("x2", "%.2f", x2);
				telemetry.addData("y2", "%.2f", y2);
				telemetry.update();
			}

			double g2y1 = gamepad2.right_stick_y;

			if((g2y1>0 && !robot.liftts.isPressed()) || g2y1<=0) {
				robot.liftMotor.setPower(g2y1);
			}
			else{
				robot.liftMotor.setPower(0);
			}

			if(gamepad2.b){
				robot.driveTrain.driveForInches(9, 1);
			}

			if(gamepad2.y){
				robot.driveTrain.turn(9, 1, this);
			}

			if(gamepad2.x){
				robot.driveTrain.turn(9, -1, this);
			}
		}
	}
}