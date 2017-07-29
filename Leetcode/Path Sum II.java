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
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;

        if (node.left == null && node.right == null && sum == node.val) {
            path.add(node.val);
            res.add((List<Integer>) path.clone());
            path.remove(path.size() - 1);
            return;
        }

        path.add(node.val);
        dfs(node.left, sum - node.val);
        dfs(node.right, sum - node.val);
        path.remove(path.size() - 1);
    }
}
