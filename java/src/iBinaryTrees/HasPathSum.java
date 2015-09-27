package iBinaryTrees;

public class HasPathSum {

	public boolean hasPathSum(BinaryTree node, int sum){
		
	/*	if(node.getLeft()==null && node.getRight() ==null && sum==0)
			return true;*/
		if(node==null) return(sum==0);
		int subSum = sum - node.getData();
		return hasPathSum(node.getLeft(), subSum) || hasPathSum(node.getRight(), subSum);
	
	}
}
