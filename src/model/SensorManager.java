package model;

import java.util.ArrayList;

import naryTree.*;

public class SensorManager {
	private NaryTree<Sensor> mainTree;
	private SplayTree<NaryTreeNode<Sensor>> splayTree;

	public SensorManager() {
		CreateSensorTree();
		splayTree = new SplayTree<NaryTreeNode<Sensor>>();
	}

	private void CreateSensorTree() {
		mainTree = new NaryTree<Sensor>(new NaryTreeNode<Sensor>(new Sensor("Planta")));
	}

	// Solo carga en la raiz del arbol
	public void LoadSensors(ArrayList<Sensor> pInitialSensorList) {
		for (Sensor sensor : pInitialSensorList) {
			AddSensor(sensor, mainTree.getRoot());
		}
	}

	public void AddSensor(Sensor pSensor, NaryTreeNode<Sensor> pParentNaryNode) {
		NaryTreeNode<Sensor> node = new NaryTreeNode<Sensor>(pSensor);
		mainTree.AddTo(pParentNaryNode, node);
		splayTree.add(node);
	}

	public void DeleteSensor(NaryTreeNode<Sensor> pNode) {
		mainTree.DeleteNode(pNode);
		// splayTree.deleteNode();
	}
	// Funciones de buscar con el splay aqui

	// Recorridos excluyen la raiz
	public void ChangeValues() {
		for (NaryTreeNode<Sensor> child : mainTree.getRoot().getChildrenList()) {
			ChangeValuesAux(child);
		}
	}

	public void ChangeValuesAux(NaryTreeNode<Sensor> pNode) {
		for (NaryTreeNode<Sensor> child : pNode.getChildrenList()) {
			ChangeValuesAux(child);
		}
		int intake = 1; // Aqui va una funcion que calcula el cambio del intake de una vez
		pNode.getValue().notEnoughWater();
		pNode.getValue().setIntake(intake);
	}

	public void CheckWaterFlow() {
		int waterLeft[] = new int[1];
		waterLeft[1] = mainTree.getRoot().getValue().getIntake();
		for (NaryTreeNode<Sensor> child : mainTree.getRoot().getChildrenList()) {
			if (waterLeft[1] < 0) {
				break;
			}
			CheckWaterFlowAux(child, waterLeft);
		}
	}

	public void CheckWaterFlowAux(NaryTreeNode<Sensor> pNode, int[] pWaterLeft) {
		pWaterLeft[1] -= pNode.getValue().getIntake();
		if (pWaterLeft[1] >= 0) {
			pNode.getValue().hasEnoughWater();
			for (NaryTreeNode<Sensor> child : mainTree.getRoot().getChildrenList()) {
				if (pWaterLeft[1] < 0) {
					break;
				}
				CheckWaterFlowAux(child, pWaterLeft);
			}
		}
	}

}
