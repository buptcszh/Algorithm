/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 遍历时直接改变方向
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        
        // 创建三个指针
        ListNode pre = null, node = head, next = null;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
