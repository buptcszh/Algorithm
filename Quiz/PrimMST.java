public class PrimMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private Queue<Edge> pq;

    private void primMST(Graph G) {

        marked = new boolean[G.V()];
        mst = new LinkedList<>();  // MST队列
        pq = new PriorityQueue<>();  // 横切边优先队列

        visit(G, 0);
        while (!pq.isEmpty()) {

            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);

            if (marked[v] && marked[w]) continue;  // 跳过无效的边
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
            mst.offer(e);
        }
    }

    // 标记顶点v，并将新的横切边加入pq
    private void visit(Graph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) pq.offer(e);
        }
    }

    public static void main(String[] args) {

    }
}

class Graph {

    private final int V;
    private int E;
    private List<Edge>[] adj;

    // 确定顶点数
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    // 添加边
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public List<Edge> adj(int v) {
        return adj[v];
    }
}

class Edge implements Comparable<Edge> {

    public int v;
    public int w;
    public double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() { return v; }

    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException();
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return +1;
        else return 0;
    }
}
