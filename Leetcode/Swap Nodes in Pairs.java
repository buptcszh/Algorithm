public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode cur = start, prev;
        while (cur.next != null && cur.next.next != null) {
            
            prev = cur.next;
            
            cur.next = cur.next.next;
            prev.next = cur.next.next;
            cur.next.next = prev;
            
            cur = cur.next.next;
        }
        return start.next;
    }
}