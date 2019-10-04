package naryTree;

public class NaryTree<V> {
	//cambio
	private NaryTreeNode<V> root;
	public NaryTree() {
		//root = new NaryTreeNode<V>(new Sensor()) //planta
	}
	public void AddTo(NaryTreeNode<V> pParentNode, NaryTreeNode<V> pNode){
		pParentNode.AddChild(pNode);
	}
	
	public void ChangeValues() {
		//Va para la clase manager
	}
	public void ChangeValuesAux(NaryTreeNode<V> pNode) {
		for(int childIndex = 0; childIndex<pNode.getChildNum();childIndex++) {
			ChangeValuesAux(pNode.getChildrenList().get(childIndex));
		}
		//pNode.getValue().set; 
		pNode.getValue();
	}
}
	