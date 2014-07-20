__author__ = 'hs634'

class Stack(object):
    """
        Simple Stack Implementation. Uses Python lists for storing
        the elements in the stack.
    """
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items) - 1]

    def is_empty(self):
        return self.items == []

    def size(self):
        return len(self.items)


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

    def print_spiral(self):
        s1 = Stack()
        s2 = Stack()

        s1.push(self.root)

        while not s1.is_empty() or not s2.is_empty():
            while not s1.is_empty():
                s_top = s1.pop()
                print s_top.data
                if s_top.right is not None:
                    s2.push(s_top.right)
                if s_top.left is not None:
                    s2.push(s_top.left)

            while not s2.is_empty():
                s2_top = s2.pop()
                print s2_top.data
                if s2_top.left is not None:
                    s1.push(s2_top.left)
                if s2_top.right is not None:
                    s1.push(s2_top.right)


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

    def print_spiral(self):
        self.btree.print_spiral()

    @staticmethod
    def main():
        BinaryTreeRunner().print_spiral()


BinaryTreeRunner().main()








