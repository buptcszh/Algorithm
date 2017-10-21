/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
        node = head;
        RandomListNode cNode = node.next, cHead = node.next;
        
        while (node != null) {
            node.next = cNode.next;
            node = node.next;
            
            if (node != null) {
                cNode.next = node.next;
                cNode = cNode.next;
            } else {
                cNode.next = null;
            }
        }
        
        return cHead;
    }
}