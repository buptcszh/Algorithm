// rb树不是严格的avl树,不一定每次插入都需要调平
public class AVLTree<T extends Comparable<T>> {
    private Node root;

    class Node<T extends Comparable<T>> {
        T key;
        int height;
        Node<T> left;
        Node<T> right;

        public Node(T key, Node<T> left, Node<T> right) {
            this.key = key;
            this.height = 0;
            this.left = left;
            this.right = right;
        }
    }

    public AVLTree() {
        root = null;
    }

    private int height(Node<T> tree) {
        if (tree != null)
            return tree.height;
        return 0;
    }

    public int height() {
        return height(root);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

//          k1              l
//         /  \            / \
//        l    r          ll  k1
//       / \       ->    /    / \
//      ll lr           x    lr  r
//     /
//    x

    private Node<T> LLRotate(Node<T> k1) {
        Node<T> k2 = k1.left;

        k1.left = k2.right;
        k2.right = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.left), k1.height) + 1;

        return k2;
    }

//          k1                r
//         /  \              / \
//        l    r            k1  rr
//            / \    ->    / \    \
//           rl  rr       l   rl   x
//                \
//                 x

    private Node<T> RRRotate(Node<T> k1) {
        Node<T> k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.left), k1.height) + 1;

        return k2;
    }

//          k1                 k1               lr
//         /  \               /  \             /  \
//        l    r             lr   r           1    k1
//       / \        ->      /  \       ->    / \   / \
//      ll  lr             l   xr           ll xl xr  r
//          / \           / \
//         xl xr         ll  xl

    private Node<T> LRRotate(Node<T> k1) {
        // 对左孩子做一次RR旋转
        k1.left = RRRotate(k1.left);

        // 做一次LL旋转
        return LLRotate(k1);
    }

//          k1               k1                   rl
//         /  \             /  \                 /  \
//        l    r           l   rl               k1   r
//            / \    ->        / \      ->     / \  / \
//           rl  rr           xl  r           l  xl xr rr
//          / \                  / \
//         xl  xr               xr  rr

    private Node<T> RLRotate(Node<T> k1) {
        // 对右孩子做一次LL旋转
        k1.right = LLRotate(k1.right);

        // 做一次RR旋转
        return RRRotate(k1);
    }
}
