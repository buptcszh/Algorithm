/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ListNode node = reverse(listNode);
        ArrayList<Integer> res = new ArrayList<>();

        while (node != null) {

            res.add(node.val);
            node = node.next;
        }

        return res;
    }

    private ListNode reverse(ListNode root) {

        ListNode pre = null, cur = root, next = null;
        while (cur != null) {

            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
