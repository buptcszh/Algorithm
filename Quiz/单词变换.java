// 有一个单词列表，一个初始单词和一个最终单词，初始单词需要通过单词列表逐步变换到最终单词，求变换所需的最短变换路径长度
// 变换规则：每次只能变动1个字母

// 邻接矩阵法建图，然后用bfs或dijkstra算法求最短路径（bfs就是dijkstra算法在边权为1时的特例）
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String src = in.next();
        String tar = in.next();

        List<String> temp = new LinkedList<>();
        temp.add(src);
        while (in.hasNext()) temp.add(in.next());

        int len = temp.size();

        String[] list = temp.toArray(new String[len]);
        int[][] dis = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if (i == j) continue;
                dis[i][j] = diff(list[i], list[j]);
            }
        }

        Queue<Integer> q = new LinkedList<>();  // 保存下标即可
        int[] level = new int[len];  // 用于记录层数

        level[0] = 1;
        int i = 0;

        while (true) {
            for (int j = 0; j < len; j++) {

                if (level[j] == 0 && dis[i][j] == 1) {

                    if (list[j].equals(tar)) {

                        System.out.println(level[i] + 1);
                        return;
                    } else {

                        level[j] = level[i] + 1;
                        q.offer(j);
                    }
                }
            }
            i = q.poll();
        }
    }

    private static int diff(String a, String b) {

        int len = a.length();
        int count = 0;

        for (int i = 0; i < len; i++) {

            if (a.charAt(i) != b.charAt(i)) count++;
        }

        return count;
    }
}
