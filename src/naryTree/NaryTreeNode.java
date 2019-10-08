package naryTree;

import java.util.ArrayList;

public class NaryTreeNode<V> {
	private V value;
	private ArrayList<NaryTreeNode<V>> childrenList;
	private NaryTreeNode<V> father;
	
	public NaryTreeNode(V pValue){
		value = pValue;
		childrenList = new ArrayList<NaryTreeNode<V>>();
	}
	
	void AddChild(NaryTreeNode<V> pNode) {
		if(pNode != null) {
			childrenList.add(pNode);
			pNode.setFather(this);
		}
	}
	private void DeleteChild(NaryTreeNode<V> pNode){
		childrenList.remove(pNode);
	}
	private void GiveChildrenTo(NaryTreeNode<V> pNode) {
		pNode.childrenList.addAll(childrenList);
	}
	void FreeNode(){
		if(father != null){
			father.DeleteChild(this);
			GiveChildrenTo(father);
			childrenList.clear();
			setFather(null);
		}

	}
	public V getValue() {
		return value;
	}
	public ArrayList<NaryTreeNode<V>> getChildrenList() {
		return childrenList;
	}

	public NaryTreeNode<V> getFather() {
		return father;
	}

	private void setFather(NaryTreeNode<V> father) {
		this.father = father;
	}

	public String toString(){
		return value.toString();
	}
}
