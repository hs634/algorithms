package jTrees;

import java.util.Stack;

public class SumInBST {

	public void inorder1(BinaryTree root){
		if(root==null) return;
		Stack stack = new Stack();
		while(true){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) return;
			root = (BinaryTree) stack.pop();
			System.out.println(root.data);
			root = root.right;
		}
	}
	
	public void inorder(BinaryTree root, Stack s){
		if(root!=null){
			inorder(root.left,s);
			s.push(root.data);
			inorder(root.right,s);
		}
	}

	private void inorderR(BinaryTree root, Stack s) {
		if(root!=null){
			inorderR(root.right,s);
			s.push(root.data);
			inorderR(root.left,s);
		}	
	}
	/**
	 * Maintain a stack for inorder and another for reverse inorder. 
	 * So one gets the leftmost to root and another from rightmost to leftmost.
	 */
	public void sum(BinaryTree root, int sum){
		
		Stack inorder = new Stack();
		inorder(root, inorder);
		Stack inorderReverse = new Stack();
		inorderR(root, inorderReverse);
		
		boolean leftStack = true;
		boolean rightStack = true;
		int left = 0;
		int right = 0;
		while(true){
			if(leftStack)
				 left = (int) inorder.pop();
			if(rightStack)
				right = (int) inorderReverse.pop();
			if(left + right > sum)
				leftStack = false;
			else if(left+right < sum)
				rightStack = false;
			else
				break;
		}
		System.out.println("Elem:" + left +":" + right);
		
	}

}
