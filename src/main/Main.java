package main;

import naryTree.NaryTree;
import naryTree.NaryTreeNode;

public class Main {

	public static void main(String[] args) {
		NaryTree<Integer> tree = new NaryTree<Integer>(new NaryTreeNode<Integer>(5));
		NaryTreeNode<Integer> node = new NaryTreeNode<>(6);
		tree.AddTo(tree.getRoot(),node);
		tree.AddTo(tree.getRoot(),new NaryTreeNode<>(8));
		tree.AddTo(node,new NaryTreeNode<>(7));
		tree.Print(tree.getRoot());
		System.out.println("Hola");
		tree.DeleteNode(node);
		tree.Print(tree.getRoot());
	}

}
