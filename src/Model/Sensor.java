package Model;

import Model.TType;

public class Sensor {
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

	public void hasEnoughWater() {
		this.enoughWater = true;
	}

	public void setNewIntake(int pRange) {
		int percentage = pRange / 100;
		this.intake *= percentage;
	}
}
