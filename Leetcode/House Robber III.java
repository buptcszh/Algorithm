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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];

        int[] left = dfs(x.left);  // 获得左孩子的值
        int[] right = dfs(x.right);  // 获得右孩子的值

        int[] res = new int[2];  // 获得当前节点的值
        res[0] = x.val + left[1] + right[1];  // 抢当前节点的情况
        res[1] = left[0] + right[0];  // 不抢当前节点的情况

        return res;
    }
}
