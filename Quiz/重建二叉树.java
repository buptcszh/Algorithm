/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {

        return func(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode func(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) return null;

        TreeNode node = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {

            if (pre[startPre] == in[i]) {

                node.left = func(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                node.right = func(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }

        return node;
    }
}
