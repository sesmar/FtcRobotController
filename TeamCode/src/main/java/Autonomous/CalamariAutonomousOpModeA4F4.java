package Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Autonomous.Programs.AutonomousProgramBlue;
import Autonomous.Programs.AutonomousProgramInitialize;
import Autonomous.Programs.AutonomousProgramRed;
import Autonomous.Programs.IAutonomousProgram;

import Common.AllianceColor;
import Common.CalamariRobot;
import Common.SpikeMarkPosition;
import Common.StartingBlock;

@Autonomous(name="Calamari: Autonomous Drive A4F4", group="Calamari", preselectTeleOp = "Calamari: TeleOpMode")
public class CalamariAutonomousOpModeA4F4 extends LinearOpMode {
	CalamariRobot robot = new CalamariRobot(this);


	@Override
	public void runOpMode() throws InterruptedException {
		robot.hasVision = true;
		robot.init();
		StartingBlock startingBlock = StartingBlock.A4;

		IAutonomousProgram program = new AutonomousProgramInitialize(robot);

		waitForStart();

		if (robot.myEyes != null) {
			if (robot.myEyes.getSpikeMark() == SpikeMarkPosition.NONE
					|| robot.myEyes.getAlliance() == AllianceColor.NONE
					|| startingBlock == StartingBlock.NONE) {
				program = new AutonomousProgramInitialize(robot);
			} else if (robot.myEyes.getAlliance() == AllianceColor.RED) {
				program = new AutonomousProgramRed(robot, startingBlock);
			} else if (robot.myEyes.getAlliance() == AllianceColor.BLUE) {
				program = new AutonomousProgramBlue(robot, startingBlock);
			}

			robot.myEyes.close();
		}

		program.Run();
	}
}
