package Model;

import Model.TType;
import java.lang.Comparable;

public class Sensor implements Comparable<Sensor>{
	private String name;
	private TType type;
	private int intake;
	private String path;
	private boolean enoughWater;

	public Sensor(String pName, int pType, int pIntake, String pPath) {
		this.name = pName;
		this.type = TType.values()[pType];
		this.intake = pIntake;
		this.path = pPath;
		this.enoughWater = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public TType getType() {
		return type;
	}

	public void setType(int pType) {
		this.type = TType.values()[pType];
	}

	public int getIntake() {
		return intake;
	}

	public void setIntake(int pIntake) {
		this.intake = pIntake;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String pPath) {
		this.path = pPath;
	}
	
	public boolean getEnoughWater() {
		return this.enoughWater;
	}

	public void hasEnoughWater() {
		this.enoughWater = true;
	}
	
	public void notEnoughWater() {
		this.enoughWater = false;
	}

	public void setNewIntake(int pRange) {
		this.intake *= pRange;
	}

	@Override
	// Lexicographically compares the name of both sensors. If the sensor's name is bigger than the other sensor's name, returns a 1. Returns 0 if equal or -1 if smaller
	public int compareTo(Sensor pOtherSensor) {
		String otherName = pOtherSensor.getName();
		if (this.name.compareTo(otherName) > 0) {
			return 1;
		} else if (this.name.compareTo(otherName) < 0) {
			return -1;
		}
		return 0;
	}
}
