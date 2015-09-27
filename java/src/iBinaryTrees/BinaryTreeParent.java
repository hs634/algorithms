package iBinaryTrees;

public class BinaryTreeParent {

	int data;
	BinaryTreeParent left;
	BinaryTreeParent right;
	BinaryTreeParent parent;
	
	public BinaryTreeParent(){
		
	}
	
	public BinaryTreeParent(int data) {
		super();
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeParent getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeParent left) {
		this.left = left;
	}
	public BinaryTreeParent getRight() {
		return right;
	}
	public void setRight(BinaryTreeParent right) {
		this.right = right;
	}
	
	public static BinaryTreeParent getExampleTree(){
		BinaryTreeParent root = new BinaryTreeParent(3);
		BinaryTreeParent node1 = new BinaryTreeParent(5);
		BinaryTreeParent node2 = new BinaryTreeParent(1);
		root.setLeft(node1);
		root.setRight(node2);
		BinaryTreeParent node3 = new BinaryTreeParent(6);
		BinaryTreeParent node4 = new BinaryTreeParent(2);
		node1.setLeft(node3);
		node1.setRight(node4);
		BinaryTreeParent node5 = new BinaryTreeParent(7);
		BinaryTreeParent node6 = new BinaryTreeParent(4);
		node4.setLeft(node5);
		node4.setRight(node6);
		BinaryTreeParent node7 = new BinaryTreeParent(0);
		BinaryTreeParent node8 = new BinaryTreeParent(8);
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
