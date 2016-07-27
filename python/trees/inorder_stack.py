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
