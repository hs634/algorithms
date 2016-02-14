__author__ = 'hs634'

def trim_bst(root, low, high):
    if not root:
        return
    trim_bst(root.left, low, high)
    trim_bst(root.right, low, high)
    if low <= root.val <= high:
        return root
    if root.val < low:
        return root.right
    elif root.val > high:
        return root.left

