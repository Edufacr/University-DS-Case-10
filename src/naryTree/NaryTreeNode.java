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
}
