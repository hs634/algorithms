# 
# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
#

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.p = root
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.p is not None
        

    def next(self):
        """
        :rtype: int
        """
        out = None
        while self.p:
            if not self.p.left:
                out = self.p.val
                self.p = self.p.right
                break
            else:
                tmp = self.p.left
                while tmp.right and tmp.right != self.p:
                    tmp = tmp.right
                if not tmp.right:
                    tmp.right = self.p
                    self.p = self.p.left
                else:
                    out = self.p.val
                    tmp.right = None
                    self.p = self.p.right
                    break
        return out
                    
                    
                    
                
        

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
