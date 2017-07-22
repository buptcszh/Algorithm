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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root, pre = null;  // pre记录刚刚访问过的节点
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            TreeNode node = stack.peek();  // 先不着急弹栈
            if (node.right == null || node.right == pre) {  // 当右孩子为空，或右孩子刚刚访问过时才弹栈
                node = stack.pop();
                result.add(node.val);
                pre = node;
            } else {
                p = node.right;
            }
        }

        return result;
    }
}
