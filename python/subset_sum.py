# http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
"""
public static int count(List<Integer> list, int n, int i) {
    //System.out.print(list.size() + ", " + n);
    //System.out.println();
    if (n < 0 || i <= 0)
      return 0;

    int e = list.get(i);  // e is the i-th element in the list
    if (e == n)
      return 1 + count(list, n, i-1);   // Return 1 + check for more possibilities without picking e

    return count(list, n, i-1) + count(list, n - e, i-1);   // Result if e is not picked + result if e is picked
}
"""
public TreeNode successor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val <= p.val) {
    return successor(root.right, p);
  } else {
    TreeNode left = successor(root.left, p);
    return (left != null) ? left : root;
  }
}
Predecessor

public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}