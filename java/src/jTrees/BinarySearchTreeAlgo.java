package jTrees;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeAlgo {

	public BinaryTree search(BinaryTree root, int data){
		if(root == null)
			return null;
		if(root.data == data){
			return root;
		}
		if(data < root.data)
			return search(root.left, data);
		else
			return search(root.right, data);
	}
	
	public BinaryTree search2(BinaryTree root, int data){
		if(root == null)
			return null;
		while(root!=null){
			if(data == root.data)
				return root;
			else if(data < root.data){
				root = root.left;
			}
			else
				root = root.right;
		}
		return null;
	}
	
	public Integer min(BinaryTree root){
		if(root == null) return null;
		while(root.left != null)
			root = root.left;
		return root.data;
	}
	
	public Integer max(BinaryTree root){
		if(root == null) return null;
		while(root.right != null)
			root = root.right;
		return root.data;
	}
	/**
	 * LCA in BST is same as finding the first node whose value is between a and b
	 * Assume two nodes exist. If value at node is small that both a and b then lca must
	 * be on the right side else lcs must be on the left sideW
	 */
	
	public BinaryTree lca(BinaryTree root, BinaryTree node1, BinaryTree node2){
		
		while(true){
			if(node1.data < root.data && root.data < node2.data)
				return root;
			if(node1.data < root.data)
				root = root.left;
			else
				root = root.right;
		}
	}
	
	/**
	 * Check if bst - O(n2) space O(n)
	 */
	public boolean bst(BinaryTree root){
		if(root == null)
			return true;
		if(root.left !=null && max(root.left) > root.data) return false;
		if(root.right != null && min(root.right) < root.data) return false;
		return (bst(root.left) || bst(root.right));
	}
	
	/**
	 * O(n) and space O(n)
	 * @param root
	 * min - INT_MIN and INT_MAX
	 */
	public boolean bst2(BinaryTree root, int min, int max){
		if(root == null) return true;
		return ((root.data > min && root.data< max) && bst2(root.left, min, root.data) 
				&& bst2(root.right, root.data, max));
	}
	
	/**
	 * further improve : O(n)
	 * prev is INT_MIN
	 */
	public boolean bst3(BinaryTree root, int prev){
		if(root == null) return true;
		if(!bst3(root.left,prev)) return false;
		if(root.data < prev) return false;
		prev = root.data;
		return bst3(root.right, prev);

	}
	
	public BinaryTree arrayToBST(int[] arr, int left, int right){
		if(left < right) return null;
		BinaryTree newNode;
		if(left == right){
			newNode = new BinaryTree(arr[left]);
			newNode.setLeft(null);
			newNode.setRight(null);
		}else{
			int mid = (left + right) /2;
			newNode = new BinaryTree(arr[mid]);
			newNode.setLeft(arrayToBST(arr, left, mid-1));
			newNode.setLeft(arrayToBST(arr, left, mid-1));
		}
		return newNode;
	}
	
	public BinaryTree dllToBST(List<Integer> list){
		if(list == null || list.isEmpty())
			return null;
		int index = list.size()/2;
		BinaryTree p = new BinaryTree(list.get(index));
		p.setLeft(dllToBST(list.subList(0, index)));
		p.setLeft(dllToBST(list.subList(index+1, list.size())));
		return p;
	}
	
	public BinaryTree sortedListToBst(List list, int start, int end, Integer index){
		if(start < end)return null;
		int mid = start +(end-start) /2;
		BinaryTree leftChild = sortedListToBst(list, start,mid-1,index);
		BinaryTree parent = new BinaryTree((int) list.get(index));
		parent.setLeft(leftChild);
		index++;
		parent.setRight(sortedListToBst(list, start,mid-1,index));
		return parent;
	}
	
}
