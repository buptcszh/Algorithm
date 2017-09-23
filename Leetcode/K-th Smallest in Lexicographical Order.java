class Solution {
    // 求十叉树前序遍历的第k个数（根节点是0）
    public int findKthNumber(int n, int k) {
        int cur = 1;  // 从1开始
        k--;  // 剩余数量减1
        while (k > 0) {
            int gap = helper(n, cur, cur + 1);
            // 快速跳过gap个数，由cur转为cur+1
            if (gap <= k) {
                cur++;
                k -= gap;
            }
            // 第k个数就在下一层，由cur转为cur*10（cur在下一层的最左孩子）
            else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
    
    // 计算两个数之间的距离（同层相邻的两个数），long作为参数防止溢出
    private int helper(int n, long n1, long n2) {
        int gap = 0;
        while (n1 <= n) {
            if (n2 <= n) gap += n2 - n1;  // 肯定能从n1转移到n2
            else gap += n - n1 + 1;  // n就在n1的下一层孩子节点中
            // 转移到下一层
            n1 *= 10;
            n2 *= 10;
        }
        return gap;
    }
}