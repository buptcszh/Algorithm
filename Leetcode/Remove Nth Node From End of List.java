public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode start = new ListNode(0);  // 建立头结点
        start.next = head;
        
        ListNode slow = start, fast = start;
        for (int i = 1; i <= n; i++) {  // 调整快慢指针
            
            fast = fast.next;
        }
        
        while (fast.next != null) {
            
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return start.next;
    }
}