__author__ = 'hs634'


'''

Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes.

Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.


/* for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3         2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     6                   2
 *    / \                   / \
 *   7   4              3   1
 *        / \
 *       5   2
 *            / \
 *          3   1
 */
 '''



'''

My Answer

1. Recursively traverse to the leftmost node.
2. This becomes the NewRoot, and keep returning this value, up the chain.
3. Make the following changes
- CurrentRoot. Left.Left = CurrentRoot.Right
- CurrentRoot.Left.Right = CurrentRoot
- CurrentRoot.Left = CurrentRoot.Right = NULL


Node FlipTree ( Node root )
{
    if (root == NULL)
        return NULL;

    // Working base condition
    if( root.Left == NULL && root.Right == NULL)
    {
        return root.Left;
    }

    Node newRoot = FlipTree(root.Left);

    root.Left.Left = root.Right;
    root.Left.Right = root;
    root.Left = NULL;
    root.Right = NULL;

    return newRoot;
}
'''

def invert_tree(root):
    if not root:
        return None
    if not root.left and not root.right:
        return root
    newroot = invert_tree(root.left)
    root.left.left = root.right
    root.left.right = root
    root.left, root.right = None, None
    return newroot

