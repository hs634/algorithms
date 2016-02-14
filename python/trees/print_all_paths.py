

class Node:
    def __init__(self, data):
        self.data = data
        self.left, self.right = None, None


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

    def print_paths(self, root):
        self.print_paths_helper(root, [])

    def print_paths_helper(self, root, paths):
        if not root:
            return
        paths.append(root.data)
        if root.left is None and root.right is None:
            print "Printing path"
            print "->".join(str(p) for p in paths)
        else:
            self.print_paths_helper(root.left, list(paths))
            self.print_paths_helper(root.right, list(paths))


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

    def print_all_paths(self):
        self.btree.print_paths(self.btree.root)

    @staticmethod
    def main():
        BinaryTreeRunner().print_all_paths()


BinaryTreeRunner().main()




