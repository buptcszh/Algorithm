/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);  // 从左子树上找p、q
        TreeNode right = lowestCommonAncestor(root.right, p, q);  // 从右子树上找p、q

        if (left != null && right != null) return root;  // p、q分别在左右子树上，返回当前root
        return left != null ? left : right;  // p、q在同一棵子树上，返回非空的指针
    }
}
