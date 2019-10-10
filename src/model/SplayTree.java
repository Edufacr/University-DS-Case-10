package model;

import model.SplayTreeNode;


public class SplayTree<T> {
	private SplayTreeNode<T> root;
	
	public SplayTree() {
		this.root = null;
	}
	
	public SplayTreeNode<T> getRoot(){
		return this.root;
	}
	
	public void add(T pValue) {
		this.root = add(this.root, pValue);
	}
	
	private SplayTreeNode<T> add(SplayTreeNode<T> pNode, T pValue){
		
		if (pNode == null) {
			SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
			return node;
		}
		
		pNode = splay(pNode, pValue); // gets node for insertion
		
		if (pValue.toString().compareTo(pNode.getKey()) == 0) { 
			pNode.addContent(pValue);
			return pNode; 
		} 
		
		SplayTreeNode<T> node = new SplayTreeNode<T>(pValue);
		
		if (pValue.toString().compareTo(pNode.getKey()) < 0) {
			node.setRightChild(pNode);
			node.setLeftChild(pNode.getLeftChild());
			pNode.setLeftChild(null);
		} else{
			node.setLeftChild(pNode);
			node.setRightChild(pNode.getRightChild());
			pNode.setRightChild(null);
		}
		return node;
	}
	
	public SplayTreeNode<T> leftRotation(SplayTreeNode<T> pNode){
		SplayTreeNode<T> temp = pNode.getRightChild();
		
		pNode.setRightChild(temp.getLeftChild());
		temp.setLeftChild(pNode);
		
		
		return temp;
	}
	
	public SplayTreeNode<T> rightRotation(SplayTreeNode<T> pNode){
		SplayTreeNode<T> temp = pNode.getLeftChild();
		
		pNode.setLeftChild(temp.getRightChild());
		temp.setRightChild(pNode);
		
		
		return temp;
	}
	
	public SplayTreeNode<T> splay(SplayTreeNode<T> pNode, T pValue){
		if (pNode == null || pValue.toString().compareTo(pNode.getKey()) == 0) { // Empty tree or pValue already in tree
			return pNode;
		}
		
		if (pValue.toString().compareTo(pNode.getKey()) < 0) { // pValue < pNode.getContents()
			
			if (pNode.getLeftChild() == null) { return pNode; } // didn't find pValue
			
			if (pValue.toString().compareTo(pNode.getLeftChild().getKey()) < 0) { // left & left -> Zig Zig
				
				pNode.getLeftChild().setLeftChild(splay(pNode.getLeftChild().getLeftChild(), pValue));  // Recursively sets context for rotations
				pNode = rightRotation(pNode);
				
			} else if (pValue.toString().compareTo(pNode.getLeftChild().getKey()) > 0) { // left & right -> Zig Zag
				
				pNode.getLeftChild().setRightChild(splay(pNode.getLeftChild().getRightChild(), pValue));  // Recursively sets context for rotations
				if (pNode.getLeftChild().getRightChild() != null) {
					pNode.setLeftChild(leftRotation(pNode.getLeftChild()));
				}
				
			}
			
			if (pNode.getLeftChild() == null) {
				return pNode;
			} else { return rightRotation(pNode); }
			
			
		} else if (pValue.toString().compareTo(pNode.getKey()) > 0) { // pValue > pNode.getContents()
			
			if (pNode.getRightChild() == null) { return pNode; } // didn't find pValue
			
			if (pValue.toString().compareTo(pNode.getRightChild().getKey()) > 0) { // right & right -> Zag Zag
				
				pNode.getRightChild().setRightChild(splay(pNode.getRightChild().getRightChild(), pValue)); // Recursively sets context for rotations
				pNode = leftRotation(pNode);
				
			} else if (pValue.toString().compareTo(pNode.getRightChild().getKey()) < 0) { // right & left -> Zag Zig
				
				pNode.getRightChild().setLeftChild(splay(pNode.getRightChild().getLeftChild(), pValue));  // Recursively sets context for rotations
				if (pNode.getRightChild().getLeftChild() != null) {
					pNode.setRightChild(rightRotation(pNode.getRightChild())); 
				}
				
			}
			
			if (pNode.getRightChild() == null) {
				return pNode;
			} else { return leftRotation(pNode); }
			
		}
		return pNode;
	}
	
	public SplayTreeNode<T> splay(SplayTreeNode<T> pNode, String pValue){
		if (pNode == null || pValue.compareTo(pNode.getKey()) == 0) { // Empty tree or pValue already in tree
			return pNode;
		}
		
		if (pValue.compareTo(pNode.getKey()) < 0) { // pValue < pNode.getContents()
			
			if (pNode.getLeftChild() == null) { return pNode; } // didn't find pValue
			
			if (pValue.compareTo(pNode.getLeftChild().getKey()) < 0) { // left & left -> Zig Zig
				
				pNode.getLeftChild().setLeftChild(splay(pNode.getLeftChild().getLeftChild(), pValue)); // Recursively sets context for rotations
				pNode = rightRotation(pNode);
				
			} else if (pValue.compareTo(pNode.getLeftChild().getKey()) > 0) { // left & right -> Zig Zag
				
				pNode.getLeftChild().setRightChild(splay(pNode.getLeftChild().getRightChild(), pValue));  // Recursively sets context for rotations
				if (pNode.getLeftChild().getRightChild() != null) {
					pNode.setLeftChild(leftRotation(pNode.getLeftChild()));
				}
				
			}
			
			if (pNode.getLeftChild() == null) {
				return pNode;
			} else { return rightRotation(pNode); }
			
			
		} else if (pValue.compareTo(pNode.getKey()) > 0) { // pValue > pNode.getContents()
			
			if (pNode.getRightChild() == null) { return pNode; } // didn't find pValue
			
			if (pValue.compareTo(pNode.getRightChild().getKey()) > 0) { // right & right -> Zag Zag
				
				pNode.getRightChild().setRightChild(splay(pNode.getRightChild().getRightChild(), pValue)); // Recursively sets context for rotations
				pNode = leftRotation(pNode);
				
			} else if (pValue.compareTo(pNode.getRightChild().getKey()) < 0) { // right & left -> Zag Zig
				
				pNode.getRightChild().setLeftChild(splay(pNode.getRightChild().getLeftChild(), pValue));  // Recursively sets context for rotations
				if (pNode.getRightChild().getLeftChild() != null) {
					pNode.setRightChild(rightRotation(pNode.getRightChild())); 
				}
				
			}
			
			if (pNode.getRightChild() == null) {
				return pNode;
			} else { return leftRotation(pNode); }
			
		}
		return pNode;
	}
	
	public SplayTreeNode<T> search(T pValue){
		this.root = splay(this.root, pValue);
		return this.root;
	}
	
	public SplayTreeNode<T> search(String pKey){
		this.root = splay(this.root, pKey);
		return this.root;
	}
	
	public SplayTreeNode <T> delete(T pValue){
		this.root = delete(this.root, pValue);
		return this.root;
	}
	
	private SplayTreeNode<T> delete(SplayTreeNode<T> pNode, T pValue){
		
		if (pNode == null) {
			return null;
		}
		
		pNode = splay(pNode, pValue); // Brings the desired value to the root of the tree
		
		if (pValue.toString().compareTo(pNode.getKey()) != 0) { // Value not found
			return pNode;
		}
		
		if (pNode.getLeftChild() == null) {
			pNode = pNode.getRightChild(); // new root as there is no left sub-tree
		} else {
			SplayTreeNode<T> old = pNode;
			pNode = splay(pNode.getLeftChild(), pValue);
			pNode.setRightChild(old.getRightChild());
		}
		return pNode;
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
//		splay.add("h");
//		splay.add("d");
//		splay.add("b");
//		splay.add("a");
//		splay.add("c");
//		splay.add("f");
//		splay.add("e");
//		splay.add("g");
//		splay.add("l");
//		splay.add("j");
//		splay.add("i");
//		splay.add("k");
//		splay.add("n");
//		splay.add("m");
//		splay.add("o");
//		splay.add("h");
//		splay.print();
		
		splay.add("b");
		splay.add("d");
		splay.add("c");
		splay.add("a");
		splay.print();
	}
	
}
