package iBinaryTrees;

public class InOrderSuccessor {

	/**
	 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
	 * In Binary Search Tree, Inorder Successor of an input node can also be 
	 * defined as the node with the smallest key greater than the key of input node. 
	 * So, it is sometimes important to find next node in sorted order.
	 */
	 /*  _____20______
		/              \
	___8__          __22__
	/      \        /      \
	4     12       23       24
  		/  \
 		10   14
*/
	/**
	 * Inorder successor of 8 is 10, inorder successor of 10 is 12 and inorder successor of 14 is 20.
	 * 
	 * Method 1 : Use parent pointer:
	 *  If X has the right subtree, then successor must be the leftmodt child of the right subtree
	 *  Else got to parent P. If X is on the left side then the next node is P
	 * If X is on right then we visited the P, we need to chk successor (P)
	 */
	
	public static BinaryTreeParent inordersucc1(BinaryTreeParent node){
		if(node == null) return null;
		BinaryTreeParent parent;
		//Found the right subtree
		if(node.parent==null || node.right!=null)
			parent = leftMostNode(node);
		else{
			//Go up to left side instead of right
			while((parent = node.parent)!=null){
				if(parent.getLeft() == node)
					break;
				node = parent;
			}
			
		}
		
		return node;
		
	}
	
	public static BinaryTreeParent leftMostNode(BinaryTreeParent node){
		if(node == null) return null;
		while(node!=null){
			node = node.getLeft();
		}
		return node;
	}
	
	/**
	 * 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
	Go to right subtree and return the node with minimum key value in right subtree.
	2) If right sbtree of node is NULL, then start from root and us search like technique. Do following.
	Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
	 * 
	 * Time complexity : O(h) // h is the height of the tree
	 */
	public static BinaryTreeParent inordersucc2(BinaryTreeParent node,BinaryTreeParent root){
	
		BinaryTreeParent succ = null; 
		if(node.getRight() != null)
			return leftMostNode(node);
		
		while(root != null){
		
			if(node.data == root.data)
				return succ;
			else if(node.data < root.data){
				succ = root;
				root = root.getLeft();
			}
			else{
				root = root.getRight();
			}
		}
		return succ;
	}
	
}
