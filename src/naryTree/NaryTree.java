package naryTree;

public class NaryTree<V> {
	private NaryTreeNode<V> root;

	public NaryTree(NaryTreeNode<V> pNode) {
		root = pNode;
	}

	public void AddTo(NaryTreeNode<V> pParentNode, NaryTreeNode<V> pNode) {
		pParentNode.AddChild(pNode);
	}

	public void DeleteNode(NaryTreeNode<V> pNode) {
		if (pNode != null) {
			pNode.FreeNode();
		}
	}

	public NaryTreeNode<V> getRoot() {
		return root;
	}

	public void setRoot(NaryTreeNode<V> root) {
		this.root = root;
	}

	public void Print(NaryTreeNode<V> pNode){
		for (NaryTreeNode<V> child:pNode.getChildrenList()){
			Print(child);
		}
		System.out.println(pNode.toString());
	}
}
	