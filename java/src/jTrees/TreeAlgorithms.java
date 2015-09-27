package jTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeAlgorithms {

/**
 * Preorder traversal - root, left, right
 * Inorder traversal - left, root, right
 * Postorder traversal - left, right, root
 * 
 */
	
	public void preorder(BinaryTree root){
		if(root!=null){
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	//recursive
	public void preorder2(BinaryTree root){
		if(root == null) return;
		Stack stack = new Stack();
		while(true){
			while(root!=null){
				System.out.println(root.data);
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) break;
			root = (BinaryTree) stack.pop();
			root = root.right;
		}
	}
	
	public void inorder(BinaryTree root){
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
	
	/**
	 * Level Order traversal: Visit all the nodes at same level.
	 * like BFS, use queue
	 */

	/**
	 * inserting an element to binary tree:
	 * if empty tree, insert as root, else on level traversal, insert
	 * where empty
	 * 
	 * Size of the tree - in level order add when u pop element from queue
	 */
	
	public void levelOrder(BinaryTree root){
		Queue q = new LinkedList();
		if(root==null) return;
		q.add(root);
		BinaryTree tmp = null;
		while(!q.isEmpty()){
			tmp = (BinaryTree) q.remove();
			System.out.println(tmp.data);
			//chk if max element here
			//inc count
			if(tmp.left!=null){
				q.add(root.left);
			}//else inser element and return
			if(tmp.right!=null){
				q.add(root.right);
			}
		}
	}
	/**
	 * Maximum in binaryTree
	 */
	
	public int max(BinaryTree root){
		//null chk
		int max = Integer.MIN_VALUE;
		if(root!=null){
			int rootval  = root.data;
			int left = max(root.left);
			int right = max(root.right);
			max = right;
			if(left > right){
				max = left;
			}
			if(rootval > right){
				max = rootval;
			}
		}
		return max;
		
	}
	
	public boolean search(BinaryTree root, int data){
		if(root == null) return false;
		if(root.data == data) return true;
		return search(root.left, data) || search(root.right,data);
	}
	
	/**
	 * Deleting a binary tree - since we need to remove the children before parent,
	 * postorder traversal should be used
	 */
	public void deleteTree(BinaryTree root){
		if(root == null){
			return;
		}
		deleteTree(root.left);
		deleteTree(root.right);
		root = null;
	}
	
	/**
	 * level order in reverse : add to queue with right and then left
	 * push  to stack
	 */
	void level(BinaryTree root){
		if(root == null) return;
		Queue q = new LinkedList();
		Stack s = new Stack();
		BinaryTree tmp = null;
		while(!q.isEmpty()){
			tmp = (BinaryTree) q.remove();
			if(tmp.right!=null){
				q.add(tmp.right);
			}
			if(tmp.left!=null){
				q.add(tmp.left);
			}
			s.push(tmp);
		}
		while(!s.empty()){
			System.out.println(s.pop());
		}
	}
	
	int height(BinaryTree root){
		if(root == null) return 0;
		return 1+ Math.max(height(root.left), height(root.right));
	}
	
	/**
	 * without recursion: use modified level order
	 */
	
	public int levelheight(BinaryTree root){
		int height = 0;
		if(root==null) return height;
		Queue parent = new LinkedList();
		Queue children = new LinkedList();
		parent.add(root);
		height+=1;
		while(true){
			while(!parent.isEmpty()){
				root = (BinaryTree) parent.remove();
				if(root.left!=null){
					children.add(root.left);
				}
				if(root.right!=null){
					children.add(root.right);
				}
			}
			if(children.isEmpty()) break;
			while(!children.isEmpty()){
				//modify for calculating sum
				height+=1;
				parent.add(children.remove());
			}
		}
		
		return height;
	}
	
	/**
	 * Deepest node in the tree can be returned using level order traersal
	 * Deletion of a node can be implemented as - find the node, find the deepest node
	 * Replace the node with deepest node, then delete the deepest node
	 */
	
	/**
	 * Number of leaves - in level order chech for both left and right being null
	 * and increment count. do the opposite for full nodes. Same for half nodes
	 */
	
	/**
	 * structurally identical trees
	 */
	public boolean identical(BinaryTree tree1, BinaryTree tree2){
		if(tree1 == null && tree2 == null)
			return true;
		if(tree1 == null || tree2 == null)
			return false;
		return ((tree1.data == tree2.data) && identical(tree1.left, tree2.left) && identical(tree1.right, tree2.right));
	}
	
	/**
	 * Path with given sum
	 */
	public boolean pathSum(BinaryTree tree, int sum){
		if(tree == null)
			return false;
		 sum = sum - tree.data;
		return pathSum(tree.left, sum) || pathSum(tree.right, sum);
	}
	/**
	 * sum - root.data + add(root.left) + add(root.right);
	 */
	
	/**
	 * Mirror of tree - left is right and right is left
	 */
	public void mirror(BinaryTree root){
		if(root==null) return;
		mirror(root.left);
		mirror(root.right);
		
		BinaryTree tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}
	/**
	 * Check whether they are mirrors of each other
	 */
	
	public boolean areMirrors(BinaryTree tree1, BinaryTree tree2){
		if(tree1 == null && tree2 ==null)
			return true;
		if(tree1 == null || tree2 == null)
			return false;
		else
			return areMirrors(tree1.left, tree2.right) && areMirrors(tree1.right, tree2.left);
	}
	
	/**
	 * Problem 26 : Given inorder and post order traversal, construct tree
	 */
	
	public BinaryTree buildPreOrder(int[] preOrder, int[] inOrder,int preIndex, int start, int end){
		if(start > end) return null;
		BinaryTree newNode = new BinaryTree(preOrder[preIndex]);
		preIndex++;
		if(start == end)
			return newNode;
		int inIndex = search(inOrder, start, end, newNode.data);
		newNode.setLeft(buildPreOrder(preOrder, inOrder, preIndex, start, inIndex-1));
		newNode.setRight(buildPreOrder(preOrder, inOrder,preIndex, start, inIndex+1));
		return newNode;
	}
	
	private int search(int[] inOrder, int start, int end, int data) {
		for(int i = start; i<end; i++){
			if(inOrder[i] == data)
				return i;
		}
		return 0;
	}

	/**
	 * Find all ancestors of a node
	 */
	public BinaryTree ancestors(BinaryTree root, BinaryTree node){
		if(root==null) return null;
		if(root.getData()==node.data)
			return root;
		BinaryTree left = ancestors(root.left, node);
		BinaryTree right = ancestors(root.right, node);
		
		if(left!=null || right!=null){
			System.out.println(root.data);
			}
		return left!=null?left:right;
	}
	
	public boolean ancestors2(BinaryTree root, BinaryTree node){
		if(root==null) return false;
		if(root.left.data == node.data || root.right.data == node.data || ancestors2(root.left, node)
					||ancestors2(root.left, node)){
			System.out.println(root.getData());
			return true;
		}
		return false;
	}
	
	/**
	 * prob 30 : zigzag traversal
	 * 
	*/
	
	public void zigzag(BinaryTree root){
		if(root==null)
			return;
		Stack curLevel = new Stack();
		Stack nextLevel = new Stack();
		boolean leftToRight = true;
		curLevel.push(root);
		while(!curLevel.isEmpty()){
			BinaryTree tmp = (BinaryTree) curLevel.pop();
			if(leftToRight){
				nextLevel.push(tmp.left);
				nextLevel.push(tmp.right);
			}else{
				nextLevel.push(tmp.right);
				nextLevel.push(tmp.left);
			}
			
			if(curLevel.isEmpty()){
				leftToRight = false;
				while(!nextLevel.isEmpty()){
					curLevel.push(nextLevel.pop());
				}
			}
		}
		
	}
	
	/**
	 * prob 41 : isomorphic trees: if they have the same structure
	 */
	public boolean isomorphic(BinaryTree tree1, BinaryTree tree2){
		if(tree1==null && tree2 == null)
			return true;
		if(tree1 == null || tree2 == null )
			return false;
		return isomorphic(tree1.left, tree2.left) && isomorphic(tree1.right, tree2.right);
	}
	
	/**
	 * prob 42 : Quasi isomorphic:
	 * if tree1 can be transformed to tree2 by swapping some of left and right sub trees of tree1
	 */
	public boolean quasiIsomorphic(BinaryTree tree1, BinaryTree tree2){
		if(tree1==null && tree2 == null)
			return true;
		if(tree1 == null || tree2 == null )
			return false;
		return isomorphic(tree1.left, tree2.left) && isomorphic(tree1.right, tree2.right)
				&& isomorphic(tree1.left, tree2.right) && isomorphic(tree1.right, tree2.left);
	}
	
	public BinaryTree commonAncestor(BinaryTree root, int node1, int node2){
		if(root==null) return null;
		if(root.getData()==node1 || root.getData() == node2)
			return root;
		int count = getCount(root.left,node1, node2);
		if(count==2)
			return commonAncestor(root.left, node1, node2);
		else if(count ==1)
			return root;
		else if(count==0)
			return commonAncestor(root.right, node1, node2);
		return null;
	}

	private int getCount(BinaryTree root, int node1, int node2) {
		if(root == null) return 0;
		int count = getCount(root.left, node1, node2) + getCount(root.right, node1, node2);
		if(node1 == root.data || node2 == root.data)
			return 1 + count;
		return count;
	}
	
	/*
	 * bottom up approach: go to the leaf node, check if it equals node1 or node2
	 * send the info to parent, if both left and right are not null then return parent
	 */
	public BinaryTree commonAncestor2(BinaryTree root, int node1, int node2){
		if(root==null) return null;
		if(root.getData()==node1 || root.getData() == node2)
			return root;
		BinaryTree left = commonAncestor2(root.left, node1, node2);
		BinaryTree right = commonAncestor2(root.right, node1, node2);
		
		if(left!=null && right!=null)
			return root;
		return left!=null?left:right;
	}
	
	public int leftmostNode(BinaryTreeParent root){
		while(root.left!=null){
			root = root.left;
		}
		return root.data;
	}
	
	public int inorder(BinaryTreeParent root){
		BinaryTreeParent p = null;
		if(root.parent == null || root.right!=null)
			return leftmostNode(root.right);
		else{
			while((p = root.parent) !=null){
				if(p.left == root){
					break;
				}
				root = p;
			}
		}
		return p.data;
	}
	
	//if it is binary search tree then just maintain prev and recurse until element found
	public Integer inorder2(BinaryTreeParent root, BinaryTreeParent node){
		Integer prev = null;
		if(root.parent == null || root.right!=null)
			return leftmostNode(root.right);
		while(root!=null){
			if(root.data ==  node.data){
				return prev;
			}else if(node.data < root.data){
				prev = root.data;
				root = root.left;
			}else
				root = root.right;
		}
		
		return prev;
	}
	
	

}