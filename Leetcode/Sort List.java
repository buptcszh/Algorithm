/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // 递归出口
        if (head == null || head.next == null) return head;
        
        // 将链表分为两部分
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        // 递归对两部分排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // merge
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0), l = node;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        
        if (l1 != null) l.next = l1;
        if (l2 != null) l.next = l2;
        
        return node.next;
    }
}