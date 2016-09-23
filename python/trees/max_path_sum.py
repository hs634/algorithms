class TreeNode:
    def __init__(self, data,left = None, right = None):
        self.data = data
        self.left = left
        self.right = right


class BinaryTree:
    def __init__(self, root_node=None):
        self.root = root_node

    # All the necessary collection moduled have been already imported.
    def max_sum_path(self, root):
        self.res = float("-inf")

        def max_sum_util(root):
            if not root:
                return 0

            l = max_sum_util(root.left)
            r = max_sum_util(root.right)

            max_single = max(max(l, r) + root.data, root.data)
            max_top = max(max_single, l + r + root.data)
            self.res = max(max_top, self.res)
            return max_single

        max_sum_util(root)
        return self.res


t = TreeNode(2)
b = BinaryTree(t)
print b.max_sum_path(t)
