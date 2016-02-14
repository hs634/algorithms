__author__ = 'hs634'

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        for i, n in enumerate(self.iterate_tree(root)):
            if i+1 == k:
                return n.val
        return -1

    def iterate_tree(self, root):
        if root.left:
            for i in self.iterate_tree(root.left):
                yield i
        yield root
        if root.right:
            for i in self.iterate_tree(root.right):
                yield i