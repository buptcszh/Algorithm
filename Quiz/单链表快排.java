class Node {
    int val;
    Node next;
}

public class Main {
    private static Node partition(Node lo, Node hi) {
        int pivot = lo.val;

        Node p = lo, q = lo.next;

        // q不断向前移动，保证p之前的val都比pivot小
        while (q != hi) {  // 不与hi进行比较
            if (q.val < pivot) {
                p = p.next;
                swap(p, q);
            }
            q = q.next;
        }
        swap(p, lo);

        return p;
    }

    // sort(head, null);
    public static void sort(Node lo, Node hi) {
        if (lo != hi) {
            Node pos = partition(lo, hi);
            sort(lo, pos);
            sort(pos.next, hi);
        }
    }

    private static void swap(Node p, Node q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}