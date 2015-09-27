package iBinaryTrees;


public class LookUpBST {

	public boolean lookup(BinaryTree node, int target){
		if(node==null) return false;
		if(node.getData() == target)
			return true;
		if(node.getData() < target)
			return lookup(node.getRight(), target);
		else return lookup(node.getLeft(), target);
	}
	
	
	public BinaryTree newNode(int data){
		BinaryTree newNode = new BinaryTree(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		return newNode;
	}
	
	public BinaryTree insert(BinaryTree node, int data){
		if(node == null)
			return newNode(data);
		else{
			if(data <= node.getData())
				node.setLeft(insert(node.getLeft(), data));
			else
				node.setRight(insert(node.getRight(), data));
			return node;
		}
	}
	
	public void build123(){
		BinaryTree node = null;
		insert(node, 2 );
		insert(node, 1);
		insert(node, 3);
		
	}
	
	public int size(BinaryTree node){
		if(node == null) return 0;
		return size(node.getLeft()) + size(node.getRight()) + 1;
		
	}
	
	public int maxDepth(BinaryTree node){
		if(node == null) return 0;
		return Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight())) + 1;
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
	
	public void inorder(BinaryTree node){
		if(node == null) return;
		inorder(node.getLeft());
		System.out.println(node.getData());
		inorder(node.getRight());
	}
	
	public void postOrder(BinaryTree node){
		if(node == null) return;
		
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.println(node.getData());
	}
	
	public void doubleTree(BinaryTree node){
		BinaryTree oldLeft;
		if(node == null) return;
		doubleTree(node.getLeft());
		doubleTree(node.getRight());
		
		oldLeft = node.getLeft();
		node.setLeft(new BinaryTree(node.getData()));
		node.getLeft().setLeft(oldLeft);
	}
	
}
