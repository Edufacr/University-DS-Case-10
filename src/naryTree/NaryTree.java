package naryTree;

public class NaryTree<V> {
	private NaryTreeNode<V> root;
	public NaryTree(NaryTreeNode<V> pNode) {
		root = pNode;
	}
	public void AddTo(NaryTreeNode<V> pParentNode, NaryTreeNode<V> pNode){
		pParentNode.AddChild(pNode);
	}
	public NaryTreeNode<V> getRoot() {
		return root;
	}
	public void setRoot(NaryTreeNode<V> root) {
		this.root = root;
	}
}
	