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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return DFS(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // 以root为起点的所有路径中满足条件的路径条数
    private int DFS(TreeNode root, int sum) {
        if (root == null) return 0;

        int count = 0;
        if (root.val == sum) count++;
        count += DFS(root.left, sum-root.val);
        count += DFS(root.right, sum-root.val);

        return count;
    }
}
