__author__ = 'hs634'



class Node(object):

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class BinaryTree(object):

    def __init__(self):
        self.root = None

    def add_node(self, data):
        return Node(data)

    def insert(self, root, data):
        if root is None:
            return self.add_node(data)
        else:
            if data <= root.data:
                root.left = self.insert(root.left, data)
            else:
                root.right = self.insert(root.right, data)
            return root

