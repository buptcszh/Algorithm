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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) return res;
        
        q.offer(root);
        while (!q.isEmpty()) {
            
            int num = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            res.add(subList);
        }
        return res;
    }
}