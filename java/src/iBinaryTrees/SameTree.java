package iBinaryTrees;

public class SameTree {

	public boolean sameTree(BinaryTree node1, BinaryTree node2){
		if(node1 == null && node2 == null) return true;
		else if(node1!=null && node2!=null){
			return(
					node1.getData() == node2.getData() &&
					sameTree(node1.getLeft(), node2.getLeft()) &&
					sameTree(node1.getRight(), node2.getRight())
					);
		}
		return false;
	}
}
