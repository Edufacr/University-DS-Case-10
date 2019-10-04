package naryTree;

import java.util.ArrayList;

public class NaryTreeNode<V> {
	private V value;
	private ArrayList<NaryTreeNode<V>> childrenList;
	private int childNum;
	
	public NaryTreeNode(V pValue){
		value = pValue;
		childrenList = new ArrayList<NaryTreeNode<V>>();
		childNum = 0;
	}
	
	public void AddChild(NaryTreeNode<V> pNode) {
		if(pNode != null) {
			childrenList.add(pNode);
		}
	}

	public int getChildNum() {
		return childNum;
	}
	public void decChildNum() {
		childNum--;
	}
	public void incChildNum() {
		childNum++;
	}

	public V getValue() {
		return value;
	}
	public ArrayList<NaryTreeNode<V>> getChildrenList() {
		return childrenList;
	}
}
