import java.util.Scanner;


public class UnionFind {
    private int[] id;     // 记录节点的parent
    private int[] size;   // 记录集合的大小
    private int count;    // 记录全部集合的数量

    public UnionFind(int N) {
        count = N;
        
        id = new int[N];
        for (int i = 0;i < N;i++) {
            id[i] = i;
        }
        
        size = new int[N];
        for (int i = 0;i < N;i++) {
            size[i] = 1;
        }
    }

    // quick-find 使用了路径压缩
    public int find(int p) {
        int temp = p;
        
        while (p != id[p]) p = id[p];
        
        id[temp] = id[p];
        return p;
    }

    // quick-union 根据集合的大小来合并
    public void union(int p , int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = id[qRoot];
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = id[pRoot];
            size[pRoot] += size[qRoot];
        }

        count--;
    }
}