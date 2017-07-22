// 给定一棵二叉树的前序（根、左、右）和中序（左、根、右）的打印结果，输出此二叉树按层（从左往右）打印结果。

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {

            pre[i] = sc.nextInt();
        }

        int[] in = new int[n];
        for (int i = 0; i < n; i++) {

            in[i] = sc.nextInt();
        }

        Node root = buildTree(pre, in, 0, n - 1, 0, n - 1);
        levelTravel(root);
    }

    private static Node buildTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {

        Node node = new Node();
        node.val = pre[preStart];

        // 只有一个节点的时候，直接返回该节点
        if (preStart == preEnd && inStart == inEnd) return node;

        int pos = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == node.val) {
                pos = i;
                break;
            }
        }

        int lNum = pos - inStart;
        if (pos > inStart) node.left = buildTree(pre, in, preStart + 1, preStart + lNum, inStart, pos - 1);
        if (pos < inEnd) node.right = buildTree(pre, in, preStart + 1 + lNum, preEnd, pos + 1, inEnd);

        return node;
    }

    private static void levelTravel(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            Node node = q.poll();
            System.out.print(node.val);

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);

            if (!q.isEmpty()) System.out.print(" ");
            else System.out.println();
        }
    }
}

class Node {

    int val;
    Node left;
    Node right;
}
