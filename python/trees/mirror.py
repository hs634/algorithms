__author__ = 'hs634'

class Node():
    def __init__(self, v):
        self.val = v
        self.left = None
        self.right = None


class BinaryTree():
    def __init__(self):
        self.root = None

    def insert(self, root, v):
        if not root:
            return Node(v)
        if v < root.val:
            root.left = self.insert(root.left, v)
        else:
            root.right = self.insert(root.right, v)
        return root

    def mirror(self, root):
        if not root:
            return

        self.mirror(root.left)
        self.mirror(root.right)

        root.left, root.right = root.right, root.left

    def print_tree(self, root):
        if not root:
            return
        self.print_tree(root.left)
        print root.val,
        self.print_tree(root.right)


class BinaryTreeRunner(object):

    def __init__(self):
        self.btree = BinaryTree()
        self.btree.root = self.btree.insert(None, 5)
        root_3 = self.btree.insert(self.btree.root, 3)
        root_7 = self.btree.insert(self.btree.root, 7)
        self.btree.insert(root_3, 2)
        self.btree.insert(root_3, 4)
        self.btree.insert(root_7, 6)
        self.btree.insert(root_7, 8)

    def mirror(self):
        print "Before"
        self.btree.print_tree(self.btree.root)
        self.btree.mirror(self.btree.root)
        print "After"
        self.btree.print_tree(self.btree.root)

    @staticmethod
    def main():
        BinaryTreeRunner().mirror()


BinaryTreeRunner().main()



  5
 3 7
2 4 6 8

  5
 7 3
8 6 4 2
