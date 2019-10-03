package Model;

import java.util.*;

public class SplayTreeNode<T> implements Comparable<SplayTreeNode<T>>{
	private SplayTreeNode<T> father;
	private SplayTreeNode<T> rightChild;
	private SplayTreeNode<T> leftChild;
	private T contents;
	
	
	// Constructor for the root node when creating the tree
	public SplayTreeNode(T contents) {
		this.father = null;
		this.rightChild = null;
		this.leftChild = null;
	}
	
	public SplayTreeNode(SplayTreeNode<T> pFather, T pContents) {
		this.father = pFather;
		this.rightChild = null;
		this.leftChild = null;
		this.contents = pContents;
	}

	public SplayTreeNode<T> getFather() {
		return father;
	}

	public void setFather(SplayTreeNode<T> pFather) {
		this.father = pFather;
	}

	public SplayTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(SplayTreeNode<T> pRightChild) {
		this.rightChild = pRightChild;
	}

	public SplayTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(SplayTreeNode<T> pLeftChild) {
		this.leftChild = pLeftChild;
	}

	public T getContents() {
		return contents;
	}

	public void setContents(T pContents) {
		this.contents = pContents;
	}
	
	public int compareTo(SplayTreeNode<T> pOtherNode){
		return 0;
	}
	
}
