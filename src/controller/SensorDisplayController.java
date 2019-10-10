package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.*;
import naryTree.NaryTreeNode;

public class SensorDisplayController implements IConstants{
	private SensorManager manager;
	private JsonManager infoLoader;
	
	public SensorDisplayController(){
		manager = new SensorManager();
		infoLoader = new JsonManager();
		manager.CreateSensorTree(infoLoader.getCapacity(JSON_PATH));
		try {
			manager.LoadSensors(infoLoader.loadJson(JSON_PATH, manager));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Add(NaryTreeNode<Sensor> pNode,int pIntake, String pCanton, String pDistrito, String pBarrio ) {
		manager.AddSensor(manager.GenerateSensor(pIntake, pCanton, pDistrito, pBarrio), pNode);
	}
	public void Remove(NaryTreeNode<Sensor> pNode) {
		manager.DeleteSensor(pNode);
	}
	
	public ArrayList<Sensor> loadJson() {
		ArrayList<Sensor> sensorList = new ArrayList<Sensor>();
		try {
			sensorList.addAll(infoLoader.loadJson(JSON_PATH, manager));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sensorList;
	}
	
	public static void main(String[] args) {
		SensorDisplayController s = new SensorDisplayController();
	}
	
}
