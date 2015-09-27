package iBinaryTrees;

public class BinaryTree {

	int data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(){
		
	}
	
	public BinaryTree(int data) {
		super();
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	
	public static BinaryTree getExampleTree(){
		BinaryTree root = new BinaryTree(3);
		BinaryTree node1 = new BinaryTree(5);
		BinaryTree node2 = new BinaryTree(1);
		root.setLeft(node1);
		root.setRight(node2);
		BinaryTree node3 = new BinaryTree(6);
		BinaryTree node4 = new BinaryTree(2);
		node1.setLeft(node3);
		node1.setRight(node4);
		BinaryTree node5 = new BinaryTree(7);
		BinaryTree node6 = new BinaryTree(4);
		node4.setLeft(node5);
		node4.setRight(node6);
		BinaryTree node7 = new BinaryTree(0);
		BinaryTree node8 = new BinaryTree(8);
		node2.setLeft(node7);
		node2.setRight(node8);
		/*
		 *    _____3______
       		/              \
    	   ___5__          ___1__
   		  /      \        /      \
   		  6      _2       0       8
         	    /  \
                7   4
		 */

		return root; 
	}
	
}
