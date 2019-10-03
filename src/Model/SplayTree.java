package Model;

import Model.SplayTreeNode;



public class SplayTree <T>{
	
	private SplayTreeNode<T> root;
	
	public SplayTree() {
		this.root = null;
	}
	
	public void add(T pValue) {	
		SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
		
		if (this.root.equals(null)) {
			this.root = node;
		}
		//Comparable<SplayTreeNode<T>> compNode = (Comparable<SplayTreeNode<T>>) pNode;
		//compNode.compareTo(o);
	}
	
	public void zig() {}
	
	public void zigZag() {}
	
	public void zigZig() {}
	
	public T search(T pValue) {
		
		if (root.getContents().equals(pValue)) {
			return pValue;
		} 
		
		return null;
	}
}
