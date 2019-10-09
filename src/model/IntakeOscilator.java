package model;

import java.util.Random;

import model.IConstants;

public class IntakeOscilator implements IConstants{
	private Random random;

	public IntakeOscilator() {
		this.random = new Random();
	}

	public int oscilationPercentage() {
		int percent = random.nextInt(max_percentage + min_percentage) - min_percentage;
		percent *= 0.01;
		return percent;
	}
}
