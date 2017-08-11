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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, inorder, 0, 0, inorder.length - 1);
    }

    // 前序：r()[]  中序：()r[]
    // pstart定位root的位置，istart和iend定位子树的范围
    private TreeNode recursion(int[] pre, int[] in, int pstart, int istart, int iend) {
        if (istart > iend) return null;

        TreeNode root = new TreeNode(pre[pstart]);

        int pos = 0;
        for (pos = istart; pos <= iend; pos++) {
            if (in[pos] == pre[pstart]) break;
        }
        int k = pos - istart;  // 即()的长度

        root.left = recursion(pre, in, pstart + 1, istart, pos - 1);     // pstart + 1是左子树的根
        root.right = recursion(pre, in, pstart + k + 1, pos + 1, iend);  // pstart + k + 1是右子树的根

        return root;
    }
}
