package model;


public class SplayTreeNode<T>{
	private SplayTreeNode<T> father;
	private SplayTreeNode<T> rightChild;
	private SplayTreeNode<T> leftChild;
	private T contents;
	private int balance;
	
	
	public SplayTreeNode(T pContents) {
		this.father = null;
		this.rightChild = null;
		this.leftChild = null;
		this.contents = pContents;
		this.balance = 0;
	}

	public SplayTreeNode<T> getFather() {
		return this.father;
	}

	public void setFather(SplayTreeNode<T> pFather) {
		this.father = pFather;
	}

	public SplayTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	public void setRightChild(SplayTreeNode<T> pRightChild) {
		this.rightChild = pRightChild;
	}

	public SplayTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	public void setLeftChild(SplayTreeNode<T> pLeftChild) {
		this.leftChild = pLeftChild;
	}

	public T getContents() {
		return this.contents;
	}

	public void setContents(T pContents) {
		this.contents = pContents;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int pBalance) {
		this.balance = pBalance;
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
 