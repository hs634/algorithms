package iBinaryTrees;

import java.util.Stack;

public class SpiralTraversal {
	public void printSpiral(BinaryTree node){
		
		if(node == null) return;
		Stack<BinaryTree> currentLevel = new Stack<BinaryTree>();
		Stack<BinaryTree> nextLevel = new Stack<BinaryTree>();
		currentLevel.add(node);
		boolean leftToRight = true;
		
		while(!currentLevel.isEmpty()){
			BinaryTree tmp = (BinaryTree) currentLevel.pop();
			if(tmp!=null){
				System.out.println(tmp.getData());
				if(leftToRight){
					nextLevel.push(node.getLeft());
					nextLevel.push(node.getRight());
				}
				else{
					nextLevel.push(node.getRight());
					nextLevel.push(node.getLeft());
				}
			}
			if(currentLevel.isEmpty()){
				while(nextLevel.isEmpty()){
					currentLevel.push(nextLevel.pop());
				}
			}
			
		}
		
	}
	
	public void recursiveSpiral(BinaryTree node){
		boolean leftToRight = false;
		int height = 3;
		for(int d=1; d < height; d++){
			printGivenLevel(node, d, leftToRight);
			leftToRight = !leftToRight;
		}
	}


	private void printGivenLevel(BinaryTree node, int d, boolean leftToRight) {

		if(d==1){
			System.out.println(node.getData());
		}
		else{
			if(leftToRight){
				printGivenLevel(node.getLeft(), d-1, leftToRight);
				printGivenLevel(node.getRight(), d-1, leftToRight);
			}else{
				printGivenLevel(node.getRight(), d-1, leftToRight);
				printGivenLevel(node.getLeft(), d-1, leftToRight);
			}
		}
	}
}
