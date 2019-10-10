package model;

import java.util.ArrayList;

import naryTree.*;

public class SensorManager implements IConstants {
	private NaryTree<Sensor> mainTree;
	private SplayTree<NaryTreeNode<Sensor>> splayTree;
	private IntakeOscilator intakeCalc;

	public SensorManager() {
		splayTree = new SplayTree<NaryTreeNode<Sensor>>();
		intakeCalc = new IntakeOscilator();
	}

	public void CreateSensorTree(int pCapacity) {
		mainTree = new NaryTree<Sensor>(new NaryTreeNode<Sensor>(new Sensor("Planta", pCapacity)));
	}

	
	public void LoadSensors(ArrayList<Sensor> pInitialSensorList) {

		for (Sensor sensor : pInitialSensorList) {
			if (sensor.getType() == TType.Cantón){
				AddSensor(sensor, mainTree.getRoot());
			} else if (sensor.getType() == TType.Distrito) {
				for (NaryTreeNode<Sensor> node : splayTree.search(sensor.getLocation()[0]).getContents()) {
					if (node.getValue().getType() == TType.Cantón) {
						AddSensor(sensor, node);
					}
				}
			} else {
				for (NaryTreeNode<Sensor> node : splayTree.search(sensor.getLocation()[1]).getContents()) {
					if (node.getValue().getType() == TType.Distrito) {
						AddSensor(sensor, node);
					}
				}
			}
		}
	}

	public Sensor GenerateSensor(int pIntake, String pCanton, String pDistrito, String pBarrio ) {
		return new Sensor(pIntake,pCanton,pDistrito,pBarrio);
	}

	public FlatenedTreeNode<NaryTreeNode<Sensor>> GenerateFlatenedTreeNode(NaryTreeNode<Sensor> pNode,int pDepth) {
		return new FlatenedTreeNode<NaryTreeNode<Sensor>>(pNode, pDepth);
	}

	public NaryTreeNode<Sensor> AddSensor(Sensor pSensor, NaryTreeNode<Sensor> pParentNaryNode) {
		NaryTreeNode<Sensor> node = new NaryTreeNode<Sensor>(pSensor);
		mainTree.AddTo(pParentNaryNode, node);
		splayTree.add(node);
		return node;
	}

	public void DeleteSensor(NaryTreeNode<Sensor> pNode) {
		mainTree.DeleteNode(pNode);
		splayTree.delete(pNode);
	}
	
	public ArrayList<NaryTreeNode<Sensor>> splaySearch(String pKey){
		return splayTree.search(pKey).getContents();
	}

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

	public ArrayList<FlatenedTreeNode<NaryTreeNode<Sensor>>> FlatenMainTree(){
		ArrayList<FlatenedTreeNode<NaryTreeNode<Sensor>>> retList = new ArrayList<FlatenedTreeNode<NaryTreeNode<Sensor>>>();
		for (NaryTreeNode<Sensor> child : mainTree.getRoot().getChildrenList()) {
			FlatenMainTree(child, retList, 1);
		}
		return retList;
	}
	private void FlatenMainTree(NaryTreeNode<Sensor> pNode,ArrayList<FlatenedTreeNode<NaryTreeNode<Sensor>>> pRetList,int pDepth){
		pRetList.add(GenerateFlatenedTreeNode(pNode, pDepth));
		for (NaryTreeNode<Sensor> child : pNode.getChildrenList()) {
			FlatenMainTree(child, pRetList,pDepth++);
		}
	}
}
