package iBinaryTrees;

public class LCA {

	//find the lca of 0,8
	//lca of 6 and 4
	//lca of 3 and 8
	/*
	 *  		  _____3______
   				/              \
	   		___5__          ___1__
		  /      \        /      \
		  6      _2       0       8
     	    	/  \
            	7   4
	 */
	/**
	 * http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
	 * TOP DOWN APPROACH: avg case = O(n)
	 * Worst case = 0(n2)
	 * 1. In this approach check if the root itseld is one of the node,
	 * then return the root itself as the lca
	 * 
	 * 2. Check the left side of the node if it contains both the nodes,
	 * if so go down a level to the left, and check if they are on same side or diff(count again)
	 * 
	 * 3. If the left side contains only 1, then the current node is lca.
	 * 4. If the left side contains no nodes matching, then go to the right of the tree
	 * 
	 */
	public static void main(String[] args){
		
		BinaryTree root = BinaryTree.getExampleTree();
		
		BinaryTree lca = getLCA(root,  6,  4);
		System.out.println("LCA of 6 and 4 is:" +lca.getData());
		
		 lca = getLCA(root,  0,  8);
		System.out.println("LCA of 0 and 8 is:" +lca.getData());
		
		 lca = getLCA(root,  3,  8);
		System.out.println("LCA of 3 and 8 is:" +lca.getData());
		
		System.out.println("-----------------");
		 lca = getLCA2(root,  6,  4);
		System.out.println("LCA of 6 and 4 is:" +lca.getData());
		
		 lca = getLCA2(root,  0,  8);
		System.out.println("LCA of 0 and 8 is:" +lca.getData());
		
		 lca = getLCA2(root,  3,  8);
		System.out.println("LCA of 3 and 8 is:" +lca.getData());
		
	}

	private static BinaryTree getLCA(BinaryTree root, Integer p, Integer q) {

		if(root == null || p== null || q==null)
			return null;
		if(root.getData()==p || root.getData() == q)
			return root;
		int countMatches = getCountMatches(root.getLeft(), p , q);
		
		if(countMatches == 2)
			return getLCA(root.getLeft(), p , q);
		else if(countMatches == 1)
			return root;
		else if(countMatches == 0)
			return getLCA(root.getRight(), p , q);
		
		return null;
	}

	private static int getCountMatches(BinaryTree root, Integer p, Integer q) {
		if(root==null) return 0;
		int matches = getCountMatches(root.getLeft(),p,q) + getCountMatches(root.getRight(),p,q);
		if(root.getData() == p || root.getData() == q)
			return 1+ matches;
		return matches;
	}
	
	/**
	 * BOTTOM UP APPROACH. Worst case - O(n)
	 * We traverse from the bottom, and once we reach a node which matches one of the two nodes, 
	 * we pass it up to its parent. The parent would then test its left and right subtree if each 
	 * contain one of the two nodes. If yes, then the parent must be the LCA and we pass its parent
	 * up to the root. If not, we pass the lower node which contains either one of the two nodes 
	 * (if the left or right subtree contains either p or q), or  NULL 
	 * (if both the left and right subtree does not contain either p or q) up.
	 */
	
	public static BinaryTree getLCA2(BinaryTree root, Integer p , Integer q){
		if(root == null) return null;
		if(root.getData() == p || root.getData() == q)
			return root;
		BinaryTree left = getLCA2(root.getLeft(), p , q);
		BinaryTree right = getLCA2(root.getRight(), p , q);
		
		if(left!= null && right!=null)
			return root;
		
		return (left !=null)? left:right;
		
	}
	
}
