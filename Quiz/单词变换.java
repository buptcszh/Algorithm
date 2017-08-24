// 有一个单词列表，一个初始单词和一个最终单词，初始单词需要通过单词列表逐步变换到最终单词，求变换所需的最短变换路径长度
// 变换规则：每次只能变动1个字母

// 邻接矩阵法建图，然后用bfs或dijkstra算法求最短路径（bfs就是dijkstra算法在边权为1时的特例）
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String src = sc.nextLine();
        String dst = sc.nextLine();
        String[] temp = sc.nextLine().split(" ");

        int s = 0, d = 0;
        List<String> list = new ArrayList<>();  // 单词列表，src编号为0，dst编号为d

        list.add(src);
        for (int i = 0, count = 1; i < temp.length; i++, count++) {
            if (temp[i].equals(dst)) d = count;
            list.add(temp[i]);
        }

        int V = list.size();  // 节点数
        List<Pair>[] adj = (LinkedList<Pair>[]) new LinkedList[V];  // 邻接表
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (hasEdge(list.get(i), list.get(j))) {
                    addEdge(adj, i, j, 1.0);
                }
            }
        }

        double[] dist = new double[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
        }
        dist[s] = 0;

        Queue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o1.w, o2.w);
            }
        });
        pq.offer(new Pair(s, 0.0));

        while (!pq.isEmpty()) {
            int u = pq.poll().v;

            for (Pair pair : adj[u]) {
                int v = pair.v;
                double w = pair.w;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println((int) dist[d] + 1);
    }

    private static void addEdge(List<Pair>[] adj, int u, int v, double w) {
        adj[u].add(new Pair(v, w));
        adj[v].add(new Pair(u, w));
    }

    private static boolean hasEdge(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count == 1;
    }
}

class Pair {
    int v;
    double w;

    Pair(int v, double w) {
        this.v = v;
        this.w = w;
    }
}