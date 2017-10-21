/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 最坏情况O(n*n)
class Solution {
    public ListNode sortList(ListNode head) {
        sort(head, null);
        return head;
    }
    
    private void sort(ListNode start, ListNode end) {
        if (start != end) {
            ListNode node = partition(start, end);
            sort(start, node);
            sort(node.next, end);
        }
    }
    
    private ListNode partition(ListNode start, ListNode end) {
        ListNode p = start, q = start;
        
        int pivot = start.val;
        
        while (q != end) {
            if (q.val < pivot) {
                p = p.next;
                swap(p, q);
            }
            q = q.next;
        }
        swap(start, p);
        
        return p;
    }
    
    private void swap(ListNode p, ListNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}