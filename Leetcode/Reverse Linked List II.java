/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 前插法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 设置一个头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定位到目标位置
        ListNode pre = dummy;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode next = start.next;

        // 调整n-m次就可以了
        for (int i = 0; i < n-m; i++) {
            start.next = next.next;
            next.next = pre.next;  // 不能为start
            pre.next = next;
            next = start.next;
        }

        return dummy.next;  // 不能返回head
    }
}
