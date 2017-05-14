# 给定一个二叉树，找出其最大深度。

# 二叉树的深度为根节点到最远叶子节点的距离。

# 样例
# 给出一棵如下的二叉树:

#   1
#  / \ 
# 2   3
#    / \
#   4   5
# 这个二叉树的最大深度为3.


"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""
class Solution:
    """
    @param root: The root of binary tree.
    @return: An integer
    """ 
    def maxDepth(self, root):
        # write your code here
        if root is None:
            return 0
        else:
            leftDepth = self.maxDepth(root.left)
            rightDepth = self.maxDepth(root.right)
            if leftDepth > rightDepth:
                return leftDepth + 1
            else:
                return rightDepth + 1