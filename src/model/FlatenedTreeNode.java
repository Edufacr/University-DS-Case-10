package model;

/**
 * FlatenTreeNode
 */
public class FlatenedTreeNode<N> {

    private N treeNode;
    private int depth;

    FlatenedTreeNode(N pTreeNode, int pDepth){
        setDepth(pDepth);
        setTreeNode(pTreeNode);
    }
    public int getDepth() {
        return depth;
    }

    public N getTreeNode() {
		return treeNode;
	}

	public void setTreeNode(N treeNode) {
		this.treeNode = treeNode;
	}

	public void setDepth(int depth) {
        this.depth = depth;
    }
}