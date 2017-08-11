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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursion(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    // 后序：()[]r  中序：()r[]
    private TreeNode recursion(int[] in, int[] post, int pend, int istart, int iend) {
        if (istart > iend) return null;

        TreeNode root = new TreeNode(post[pend]);

        int pos = 0;
        for (pos = istart; pos <= iend; pos++) {
            if (in[pos] == post[pend]) break;
        }

        int k = iend - pos;

        root.left = recursion(in, post, pend - k - 1, istart, pos - 1);
        root.right = recursion(in, post, pend - 1, pos + 1, iend);

        return root;
    }
}
