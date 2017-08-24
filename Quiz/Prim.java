import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// -- prim算法只能用于无向图，同样不嫩有负权值 --
// 邻接矩阵实现的时间复杂度为O(V2)，邻接表实现的时间复杂度为O(ElogV)
public class Prim {
    int V;             // 顶点数
    List<Pair>[] adj;  // 邻接表

    public Dijkstra(int V) {
        this.V = V;
        adj = (LinkedList<Pair>[]) new LinkedList[V];  // 泛型数组
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v, double weight) {
        // 无向图只是有向图的特例
        adj[u].add(new Pair(v, weight));  // 这里的w是边的权值
        adj[v].add(new Pair(u, weight));
    }

    public void primMST(int s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o1.weight, o2.weight);
            }
        });

        double[] key = new double[V];  // 记录连接该节点的边权
        int[] parent = new int[V];
        boolean[] inMST = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Double.POSITIVE_INFINITY;
            parent[i] = -1;
            inMST[i] = false;
        }

        key[s] = 0.0;
        pq.offer(new Pair(s, 0.0));  // 这里的w是源点到该节点的最短距离

        while (!pq.isEmpty()) {
            int u = pq.poll().v;

            inMST[u] = true;  // 这是prim算法和dijkstra算法不同的地方

            for (Pair e : adj[u]) {
                int v = e.v;
                double weight = e.weight;

                if (!inMST[v] && key[v] > weight) {
                    key[v] = weight;
                    pq.offer(new Pair(v, dist[v]));
                    parent[v] = u;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void main(String[] args) {
        Prim g = new Prim(9);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.primMST(0);
    }
}

class Pair {
    int v;     // 目标节点
    double w;  // 边的权值（或源点到该节点的最短距离）

    Pair(int v, double w) {
        this.v = v;
        this.w = w;
    }
}