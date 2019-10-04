package model;
import naryTree.*;
public class SensorManager {
	private NaryTree<Sensor> mainTree;
	
	public SensorManager() {
		
	}
	public void CreateSensorTree() {
		mainTree = new NaryTree<Sensor>(new NaryTreeNode<Sensor>(new Sensor("Planta")));
	}
	public void ChangeValues() {
		ChangeValuesAux(mainTree.getRoot());
	}
	public void ChangeValuesAux(NaryTreeNode<Sensor> pNode) {
		for(int childIndex = 0; childIndex<pNode.getChildNum();childIndex++) {
			ChangeValuesAux(pNode.getChildrenList().get(childIndex));
		}
		int intake = 1; //Aqui va una funcion que calcula el cambio del intake de una vez
		pNode.getValue().notEnoughWater();; 
		pNode.getValue().setIntake(intake);
	}
}
