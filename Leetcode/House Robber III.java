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
        // 每个节点有两种状态：不抢该节点，抢该节点
        // res[0]表示抢该节点时，所获取的最大金额；res[1]表示不抢该节点时，所获取的最大金额
        int[] res = dfs(root);  // 深度优先搜索计算各个节点的res值
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];

        int[] left = dfs(x.left);  // 获得左孩子的值
        int[] right = dfs(x.right);  // 获得右孩子的值

        int[] res = new int[2];  // 获得当前节点的值
        res[0] = x.val + left[1] + right[1];  // 抢当前节点的情况
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  // 不抢当前节点的情况

        return res;
    }
}
