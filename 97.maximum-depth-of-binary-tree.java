// 给定一个二叉树，找出其最大深度。

// 二叉树的深度为根节点到最远叶子节点的距离。

// 样例
// 给出一棵如下的二叉树:

//   1
//  / \ 
// 2   3
//    / \
//   4   5
// 这个二叉树的最大深度为3.


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode Node(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int level = 0;
    public int maxDepth(TreeNode root) {
        // write your code here 
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }
}