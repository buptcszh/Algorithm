public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) return true;
        if (diff(root.left, root.right) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right))
            return true;
        return false;
    }


    private int height(TreeNode root) {

        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    private int diff(TreeNode left, TreeNode right) {

        if (left == null && right == null) return 0;
        if (left == null) return height(right);
        if (right == null) return height(left);

        return (int) Math.abs(height(left) - height(right));
    }
}
