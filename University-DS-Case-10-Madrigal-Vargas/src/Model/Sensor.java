package Model;

import Model.TType;

public class Sensor {
	private String name;
	private TType type;
	private int consumoHijos;
	private String path;
	
	public Sensor(String pName, int pType, int pConsumo, String pPath) {
		this.name = pName;
		this.type = TType.values()[pType];
		this.consumoHijos = pConsumo;
		this.path = pPath;
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

	public int getConsumoHijos() {
		return consumoHijos;
	}

	public void setConsumoHijos(int pConsumoHijos) {
		this.consumoHijos = pConsumoHijos;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String pPath) {
		this.path = pPath;
	}
	
	
}
