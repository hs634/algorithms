package iBinaryTrees;

public class IsBST {
	public boolean isBst(BinaryTree node){//root
		if(node == null) return true;
		if(node.getLeft()!=null && maxValue(node.getLeft()) > node.getData()) return false;
		if(node.getRight()!=null && minValue(node.getRight()) < node.getData()) return false;
		return isBst(node.getLeft()) && isBst(node.getRight());
	}
	
	public boolean isBst2(){
		BinaryTree root = null;
		return isBst2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBst2(BinaryTree node, int min, int max){
		if(node == null) return true;
		if (node.getData() < min || node.getData() > max) return(false);
		else{
			boolean leftIsBst = isBst2(node.getLeft(), min, node.getData());
			if(!leftIsBst) return false;
			boolean rightIsBst = isBst2(node.getRight(), node.getData()+1, max);
			if(!rightIsBst) return false;
		}
		return true;
	}
	
	//Binary Search Tree
	public int minValue(BinaryTree node){
		while(node.getLeft() !=null){
			node = node.getLeft();
		}
		return node.getData();
	}
	
	public int maxValue(BinaryTree node){
		while(node.getRight() !=null){
			node = node.getRight();
		}
		return node.getData();
	}
}
