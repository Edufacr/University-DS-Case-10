package controller;

import model.*;
import naryTree.NaryTreeNode;

public class SensorDisplayController {
	private SensorManager manager;
	
	SensorDisplayController(){
		manager = new SensorManager();
	}
	SensorDisplayController(SensorManager pManager){
		manager = pManager;
	}
	public void Add(NaryTreeNode<Sensor> pNode,int pIntake, String pCanton, String pDistrito, String pBarrio ) {
		manager.AddSensor(manager.GenerateSensor(pIntake, pCanton, pDistrito, pBarrio), pNode);
	}
	public void Remove(NaryTreeNode<Sensor> pNode) {
		manager.DeleteSensor(pNode);
	}
	
}
