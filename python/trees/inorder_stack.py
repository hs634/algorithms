from collections import deque

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = deque()
        node = root
        while node:
            self.stack.append(node)
            node = node.left
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) is not 0
        

    def next(self):
        """
        :rtype: int
        """
        top = self.stack.pop()
        node = top.right
        while node:
            self.stack.append(node)
            node = node.left
        return top.val

"""
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
        while(cur!=null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }

    return list;
}
"""