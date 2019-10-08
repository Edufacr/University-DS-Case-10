package model;

import model.SplayTreeNode;
import java.lang.Comparable;


public class SplayTree<T>{

	private SplayTreeNode<T> root;
	private boolean searched;
	private boolean isEmpty;
	
	public SplayTree() {
		this.root = null;
		this.searched = false;
		this.isEmpty = true;
	}

	public void add(T pValue) {
		
		if (this.isEmpty) {
			this.isEmpty = false;
			SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
			this.root = node;
		}
		
		Comparable<T> cValue = (Comparable<T>) pValue;
		
		if(cValue.compareTo(this.root.getContents()) < 0) { // pValue < root.getValue()
			if (this.root.getLeftChild() == null) {
				SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
				this.root.setLeftChild(node);
				node.setFather(this.root);
				return;
			}
			addContinue(this.root.getLeftChild(), pValue);
		} else if(cValue.compareTo(this.root.getContents()) > 0){ // pValue > pNode.getValue()
			if (this.root.getRightChild() == null) {
				SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
				this.root.setRightChild(node);
				node.setFather(this.root);
				return;
			}
			addContinue(this.root.getRightChild(), pValue);
		}
	}

	
	private void addContinue(SplayTreeNode<T> pCurrent, T pValue){
		Comparable<T> cValue = (Comparable<T>) pValue;
		
		if(cValue.compareTo(pCurrent.getContents()) < 0) { // pValue < root.getValue()
			if (pCurrent.getLeftChild() == null) {
				SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
				pCurrent.setLeftChild(node);
				node.setFather(pCurrent);
				return;
			}
			addContinue(pCurrent.getLeftChild(), pValue);
			return;
		} else if(cValue.compareTo(pCurrent.getContents()) > 0){ // pValue > pNode.getValue()
			if (pCurrent.getRightChild() == null) {
				SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
				pCurrent.setRightChild(node);
				node.setFather(pCurrent);
				return;
			}
			addContinue(pCurrent.getRightChild(), pValue);
			return;
		}
	}

	
	// Splay Functions
	private void zig(SplayTreeNode<T> pSearched) {
		SplayTreeNode<T> oldRoot = this.root;
		if (root.getLeftChild().equals(pSearched)) {
			oldRoot.setLeftChild(pSearched.getRightChild());
			this.root = pSearched;
			this.root.setRightChild(oldRoot);
			this.root.setFather(null);
			oldRoot.setFather(this.root);
		} else if(root.getRightChild().equals(pSearched)) {
			oldRoot.setRightChild(pSearched.getLeftChild());
			this.root = pSearched;
			this.root.setLeftChild(oldRoot);
			this.root.setFather(null);
			oldRoot.setFather(this.root);
		}
	}

	
	private void zigZig(SplayTreeNode<T> pSearched) {
		SplayTreeNode<T> father = pSearched.getFather();
		SplayTreeNode<T> grandFather = father.getFather();
		SplayTreeNode<T> greatGrandFather = grandFather.getFather();
		
		if (father.getLeftChild().equals(pSearched)) {
			
			// Esception for null other child
			SplayTreeNode<T> otherChild = father.getRightChild();
			otherChild.setFather(grandFather);
			grandFather.setLeftChild(otherChild);
				
			father.setRightChild(grandFather); 
			grandFather.setFather(father); 
			
			pSearched.setFather(greatGrandFather);
			if (greatGrandFather.getLeftChild().equals(grandFather)) {
				greatGrandFather.setLeftChild(pSearched);
			} else {
				greatGrandFather.setRightChild(pSearched);
			}
			
			father.setLeftChild(pSearched.getRightChild());
			pSearched.getRightChild().setFather(father);
			
			father.setFather(pSearched);
			pSearched.setRightChild(father);
			
		} else if (father.getRightChild().equals(pSearched)) {
			
			SplayTreeNode<T> otherChild = father.getLeftChild();
			otherChild.setFather(grandFather);
			grandFather.setRightChild(otherChild);
			
			father.setLeftChild(grandFather);
			grandFather.setFather(father);
			
			pSearched.setFather(greatGrandFather);
			if (greatGrandFather.getLeftChild().equals(grandFather)) {
				greatGrandFather.setLeftChild(pSearched);
			} else {
				greatGrandFather.setRightChild(pSearched);
			}
			
			father.setRightChild(pSearched.getLeftChild());
			pSearched.getLeftChild().setFather(father);
			
			
			father.setFather(pSearched);
			pSearched.setLeftChild(father);
			
		}
	}

	
	private void zigZag(SplayTreeNode<T> pSearched) {
		SplayTreeNode<T> father = pSearched.getFather();
		SplayTreeNode<T> grandFather = father.getFather();
		SplayTreeNode<T> greatGrandFather = grandFather.getFather();
		
		if (father.getRightChild().equals(pSearched)) {
			
			pSearched.getLeftChild().setFather(father);
			father.setRightChild(pSearched.getLeftChild());
			
			pSearched.setLeftChild(father);
			father.setFather(pSearched);
			
			grandFather.setLeftChild(pSearched.getRightChild()); 
			pSearched.getRightChild().setFather(grandFather);
			
			pSearched.setRightChild(grandFather);
			grandFather.setFather(pSearched);
			
			pSearched.setFather(greatGrandFather);
			if (greatGrandFather.getLeftChild().equals(grandFather)) {
				greatGrandFather.setLeftChild(pSearched);
			} else {
				greatGrandFather.setRightChild(pSearched);
			}
			
		} else if(father.getLeftChild().equals(pSearched)) {
			
			pSearched.getRightChild().setFather(father);
			father.setLeftChild(pSearched.getRightChild());
			
			pSearched.setRightChild(father);
			father.setFather(pSearched);
			
			grandFather.setRightChild(pSearched.getLeftChild());
			pSearched.getLeftChild().setFather(grandFather);
			
			pSearched.setLeftChild(grandFather);
			grandFather.setFather(pSearched);
			
			pSearched.setFather(greatGrandFather);
			
			if (greatGrandFather.getLeftChild().equals(grandFather)) {
				greatGrandFather.setLeftChild(pSearched);
			} else {
				greatGrandFather.setRightChild(pSearched);
			}
			
		}
	}
	
	public SplayTreeNode<T> search(T pValue) {
		
		if (!this.searched) {
			this.searched = true;
		}
		
		
		Comparable<T> cValue = (Comparable<T>) pValue;
		
		if (cValue.compareTo(this.root.getContents()) == 0) {
			return this.root;
		} else if(cValue.compareTo(this.root.getContents()) < 0) { // pValue < pNode.getValue()
			return continueSearch(pValue, this.root.getLeftChild());
		} else if(cValue.compareTo(this.root.getContents()) > 0){ // pValue > pNode.getValue()
			return continueSearch(pValue, this.root.getRightChild());
		} return null;
	}
	
	
	private SplayTreeNode<T> continueSearch(T pValue, SplayTreeNode<T> pNode) {
		
		Comparable<T> cValue = (Comparable<T>) pValue;
		
		if (cValue.compareTo(pNode.getContents()) == 0) {
			this.splayMove(pNode);
			return pNode;
		} else if(cValue.compareTo(pNode.getContents()) < 0) { // pValue < pNode.getValue()
			return continueSearch(pValue, pNode.getLeftChild());
		} else if(cValue.compareTo(pNode.getContents()) > 0){ // pValue > pNode.getValue()
			return continueSearch(pValue, pNode.getRightChild());
		} 
		
		return null;
	}
	
	private void splayMove(SplayTreeNode<T> pNode) {
		
		if (pNode.equals(this.root)) {
			return;
		} else if (pNode.getFather().equals(this.root)){
			this.zig(pNode);
			return;
		}
		
		SplayTreeNode<T> father = pNode.getFather();
		SplayTreeNode<T> grandFather = father.getFather();
		
		if (grandFather.getLeftChild().equals(father)) {
			if (father.getLeftChild().equals(pNode)) {
				this.zigZig(pNode);
				splayMove(pNode);
				return;
			} else {
				this.zigZag(pNode);
				splayMove(pNode);
				return;
			}
		} else if (grandFather.getRightChild().equals(father)) {
			if (father.getRightChild().equals(pNode)) {
				this.zigZig(pNode);
				splayMove(pNode);
				return;
			} else {
				this.zigZag(pNode);
				splayMove(pNode);
				return;
			}
		}
	}
	
	public void print() {
		printPreorder(this.root);
	}
	
	
	private void printPreorder(SplayTreeNode<T> pNode) {
		
		if (pNode == null) {
			return;
		}
		
		System.out.println(pNode.getContents());
		
		printPreorder(pNode.getLeftChild());
		printPreorder(pNode.getRightChild());
	}
	
	
	public static void main(String[] args) {
		SplayTree<String> splay = new SplayTree<String>();
		splay.add("h");
		splay.add("d");
		splay.add("b");
		splay.add("a");
		splay.add("c");
		splay.add("f");
		splay.add("e");
		splay.add("g");
		splay.add("l");
		splay.add("j");
		splay.add("i");
		splay.add("k");
		splay.add("n");
		splay.add("m");
		splay.add("o");
		splay.print();
		
		System.out.println();
		System.out.println(splay.search("d").getContents());
		System.out.println();
		splay.print();
		
		
	}
}
