package iBinaryTrees;

public class PrintAllPaths {

	public void printPaths() {
		  int[] path = new int[1000];
		  BinaryTree root = new BinaryTree(1);
		  printPaths(root, path, 0);
	}
	
	public void printPaths(BinaryTree node, int[] path, int pathLen){
		if(node == null) return;
		path[pathLen] = node.getData();
		pathLen++;
		
		if(node.getLeft() == null && node.getRight() == null){
			printArray(path, pathLen);
		}
		else
		{
			printPaths(node.getLeft(), path, pathLen);
			printPaths(node.getRight(), path, pathLen);
		}
		
	}
	
	private void printArray(int[] ints, int len){
		int i;
		for(i = 0; i<len; i++){
			System.out.println(ints[i] + " ");
		}
		System.out.println();
	}
}
