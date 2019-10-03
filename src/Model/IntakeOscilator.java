package Model;

import Model.IConstants;
import java.util.Random;

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
