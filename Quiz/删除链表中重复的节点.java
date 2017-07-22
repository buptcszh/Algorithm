/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {

        ListNode root = new ListNode(-1);
        root.next = pHead;

        boolean needDelete = false;
        ListNode pre = null, cur = root;

        while (cur != null && cur.next != null) {

            if (cur.val != cur.next.val) {

                if (!needDelete) pre = cur;
                else {

                    pre.next = cur.next;
                    needDelete = false;
                }
                cur = cur.next;
            } else {

                needDelete = true;
                cur = cur.next;
            }
        }

        if (needDelete) pre.next = null;
        return root.next;
    }
}
