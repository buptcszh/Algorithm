/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode root = null;
        // 利用递归实现
        if (list1.val < list2.val) {

            root = list1;
            root.next = Merge(list1.next, list2);
        } else {

            root = list2;
            root.next = Merge(list1, list2.next);
        }

        return root;
    }
}
