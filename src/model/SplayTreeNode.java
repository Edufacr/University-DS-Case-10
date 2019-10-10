package model;


import java.util.ArrayList;

public class SplayTreeNode<T> {
	private SplayTreeNode<T> leftChild;
	private SplayTreeNode<T> rightChild;
	private String key;
	private ArrayList<T> contents;
	
	public SplayTreeNode(T pContents) {
		this.rightChild = null;
		this.leftChild = null;
		this.contents = new ArrayList<T>();
		this.contents.add(pContents);
		this.key = pContents.toString();
	}

	public SplayTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(SplayTreeNode<T> pLeftChild) {
		this.leftChild = pLeftChild;
	}

	public SplayTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(SplayTreeNode<T> pRightChild) {
		this.rightChild = pRightChild;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String pKey) {
		this.key = pKey;
	}
	
	public void addContent(T pValue) {
		this.contents.add(pValue);
	}
	
	public void removeContent(T pValue) {
		this.contents.remove(pValue);
	}
	
	public ArrayList<T> getContents(){
		return this.contents;
	}
	
	@Override
	public boolean equals(Object pOther) {
		if (this == pOther) {
			return true;
		} else if(pOther == null) {
			return false;
		}
		return false;
	}
}
 