/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {

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
