package iBinaryTrees;

public class MirrorTree {

	public void mirror(BinaryTree node){
		if(node!=null){
			mirror(node.getLeft());
			mirror(node.getRight());
			
			BinaryTree tmp = node.getLeft();
			node.setLeft(node.getRight());
			node.setRight(tmp);
		}
			
	}
}
