package Common;

import com.qualcomm.robotcore.hardware.Servo;

public class EggDropper {
	Servo _dropper1;

	Servo _dropper2;

	public EggDropper(Servo dropper1, Servo dropper2) {

		_dropper1 = dropper1;

		_dropper2 = dropper2;
	}

	public void Secure(int eggToDrop) {
		if (eggToDrop == 1) {
			_dropper1.setPosition(.7);
		} else if (eggToDrop == 2) {
			_dropper2.setPosition(.7);
		}
	}

	public void Drop(int eggToDrop) {
		if (eggToDrop == 1) {
			_dropper1.setPosition(0);
		} else if (eggToDrop == 2) {
			_dropper2.setPosition(0);
		}
	}
}