package model;

import java.util.ArrayList;

import naryTree.*;

public class SensorManager implements IConstants {
	private NaryTree<Sensor> mainTree;
	private SplayTree<NaryTreeNode<Sensor>> splayTree;
	private IntakeOscilator intakeCalc;

	public SensorManager() {
		CreateSensorTree();
		splayTree = new SplayTree<NaryTreeNode<Sensor>>();
		intakeCalc = new IntakeOscilator();
	}

	private void CreateSensorTree() {
		//Lo crea con la planta de root
		mainTree = new NaryTree<Sensor>(new NaryTreeNode<Sensor>(new Sensor("Planta",WATERPLANT_CAPACITY)));
	}

	// Solo carga en la raiz del arbol
	public void LoadSensors(ArrayList<Sensor> pInitialSensorList) {
		for (Sensor sensor : pInitialSensorList) {
			AddSensor(sensor, mainTree.getRoot());
		}
	}

	public Sensor GenerateSensor(int pIntake, String pCanton, String pDistrito, String pBarrio ) {
		return new Sensor(pIntake,pCanton,pDistrito,pBarrio);
	}

	public void AddSensor(Sensor pSensor, NaryTreeNode<Sensor> pParentNaryNode) {
		NaryTreeNode<Sensor> node = new NaryTreeNode<Sensor>(pSensor);
		mainTree.AddTo(pParentNaryNode, node);
		//splayTree.add(node);
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
		int intake = intakeCalc.getIntake(pNode.getValue().getIntake());
		pNode.getValue().notEnoughWater();
		pNode.getValue().setIntake(intake);
	}

	public void CheckWaterFlow() {
		int waterLeft[] = new int[1];
		waterLeft[0] = mainTree.getRoot().getValue().getIntake();
		for (NaryTreeNode<Sensor> child : mainTree.getRoot().getChildrenList()) {
			if (waterLeft[0] < 0) {
				break;
			}
			CheckWaterFlowAux(child, waterLeft);
		}
	}

	public void CheckWaterFlowAux(NaryTreeNode<Sensor> pNode, int[] pWaterLeft) {
		pWaterLeft[0] -= pNode.getValue().getIntake();
		if (pWaterLeft[0] >= 0) {
			pNode.getValue().hasEnoughWater();
			for (NaryTreeNode<Sensor> child : pNode.getChildrenList()) {
				if (pWaterLeft[0] < 0) {
					break;
				}
				CheckWaterFlowAux(child, pWaterLeft);
			}
		}
	}

}
