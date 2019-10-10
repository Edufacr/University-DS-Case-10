package model;

import java.lang.Comparable;

import model.TType;

public class Sensor implements Comparable<Sensor>{
	private String[] location = new String[3];
	private int intake;
	private String name;
	private TType type;
	private boolean enoughWater;

	public Sensor(int pIntake, String pCanton, String pDistrito, String pBarrio){
		intake = pIntake;
		enoughWater = false;
		location[0] = pCanton;
		location[1] = pDistrito;
		location[2] = pBarrio;
		int typeNum = DetermineType(); 
		name = location[typeNum - 1];
		type = TType.values()[typeNum - 1];
	}
	public Sensor(String pName,int pIntake) {
		//por mientras para la planta
		//se deberia poner type depende de si se usa en la interfaz
		name = pName;
		intake = pIntake;
	}
	private int DetermineType(){
		int localIndex;
		for (localIndex = 0; localIndex < 3; localIndex++) {
			if (location[localIndex].isEmpty()) {
				break;
			}
		}
		return localIndex--;
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
	
	public String[] getLocation() {
		return this.location;
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
	
	@Override
	public String toString() {
		return this.name;
	}
}
