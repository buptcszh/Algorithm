import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class Dijkstra {
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

    public void shortestPath(int s) {
        // 用优先队列保存unvisited nodes，这样可以用O(1)的时间复杂度找到距离源点最近的node
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o1.w, o2.w);
            }
        });

        double[] dist = new double[V];  // 记录源点到各个节点的最短距离
        for (int i = 0; i < V; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
        }

        dist[s] = 0.0;
        pq.offer(new Pair(s, 0.0));  // 这里的w是源点到该节点的最短距离

        while (!pq.isEmpty()) {
            int u = pq.poll().v;  // dist[u]已经确定

            for (Pair e : adj[u]) {
                int v = e.v;
                double weight = e.w;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    // decrease key。应该是先删除node，再添加node。但直接添加对结果也没有影响
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(dist[i]);
        }
    }

    public static void main(String[] args) {
        Dijkstra g = new Dijkstra(9);

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

        g.shortestPath(0);
    }
}

class Pair {
    int v;     // 目标节点
    double w;  // 边的权值（或源点到该节点的最短距离【复用了w】）

    Pair(int v, double w) {
        this.v = v;
        this.w = w;
    }
}