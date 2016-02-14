__author__ = 'hs634'


#Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BinaryTree(object):

    def __init__(self):
        self.root = None

    def add_node(self, val):
        return TreeNode(val)

    def insert(self, root, data):
        if root is None:
            return self.add_node(data)
        else:
            if data <= root.val:
                root.left = self.insert(root.left, data)
            else:
                root.right = self.insert(root.right, data)
            return root

    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        ncl = 1
        nnl = 0
        cur = root
        queue = []
        queue.append(cur)
        result, level = [], []
        while len(queue) > 0:
            t = queue.pop(0)
            ncl -= 1
            if t:
                level.append(t.val)
                queue.append(t.left)
                queue.append(t.right)
                nnl += 2
            if ncl == 0:
                result.append(level)
                level = []
                ncl = nnl
                nnl = 0
        if level:
            result.append(level)
        return result


class BinaryTreeRunner(object):

    def __init__(self):
        self.btree = BinaryTree()
        self.btree.root = self.btree.insert(None, 2)
        root_3 = self.btree.insert(self.btree.root, 1)
        root_7 = self.btree.insert(self.btree.root, 3)

    def level_order(self):
        self.btree.levelOrder(self.btree.root)

    @staticmethod
    def main():
        BinaryTreeRunner().level_order()


BinaryTreeRunner().main()