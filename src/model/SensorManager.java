package model;

import java.util.ArrayList;

import naryTree.*;

public class SensorManager {
	private NaryTree<Sensor> mainTree;
	private SplayTree<NaryTreeNode<Sensor>> splayTree;

	public SensorManager(ArrayList<Sensor> pInitialSensorList) {
		CreateSensorTree();
		splayTree = new SplayTree<NaryTreeNode<Sensor>>();
		

	}

	//public void Load

	private void CreateSensorTree() {
		mainTree = new NaryTree<Sensor>(new NaryTreeNode<Sensor>(new Sensor("Planta")));
	}

	public void ChangeValues() {
		ChangeValuesAux(mainTree.getRoot());
	}

	public void ChangeValuesAux(NaryTreeNode<Sensor> pNode) {
		for (NaryTreeNode<Sensor> child : pNode.getChildrenList()) {
			ChangeValuesAux(child);
		}
		int intake = 1; // Aqui va una funcion que calcula el cambio del intake de una vez
		pNode.getValue().notEnoughWater();
		;
		pNode.getValue().setIntake(intake);
	}
}
