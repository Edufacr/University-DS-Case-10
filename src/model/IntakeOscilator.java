package model;

import java.util.Random;

import model.IConstants;

public class IntakeOscilator implements IConstants{
	private Random random;

	public IntakeOscilator() {
		this.random = new Random();
	}

	public int oscilationPercentage() {
		int percent = random.nextInt(MAX_PERCENTAGE + MIN_PERCENTAGE) - MIN_PERCENTAGE;
		percent *= 0.01;
		return percent;
	}

	public int getIntake(int pIntake){
		return pIntake + (pIntake * oscilationPercentage());
	}
}
