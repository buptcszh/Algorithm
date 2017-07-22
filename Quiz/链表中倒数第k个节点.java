/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null || k == 0) return null;

        ListNode fast = head;
        // 快指针先走k-1步
        for (int i = 0; i < k - 1; i++) {

            if (fast.next != null) fast = fast.next;
            else return null;
        }

        ListNode slow = head;
        while (fast.next != null) {

            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
