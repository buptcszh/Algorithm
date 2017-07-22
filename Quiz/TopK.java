import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Solution {
    public static void main(String[] args) {

        String[] s = new String[]{"aaa", "aaa", "aaa", "bb", "bb", "c", "c", "c", "c"};
        int k = 3;

        Map<String, Integer> m = new HashMap<>();
        for (String x : s) {

            if (m.get(x) == null) m.put(x, 1);
            else m.put(x, m.get(x)+1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(m.entrySet());

        // 建大根堆
        int N = list.size();
        for (int i = N / 2; i >= 1; i--) {

            sink(list, i, N);
        }

        // 求前k大的数
        for (; k > 0; k--) {

            System.out.println(list.get(0).getKey() + ": " + list.get(0).getValue());
            swap(list, 1, N--);
            sink(list, 1, N);
        }
    }

    //private void swim() {}

    private static void sink(List<Map.Entry<String, Integer>> list, int i, int N) {

        while (2 * i <= N) {

            int j = 2 * i;

            if (j < N && less(list, j, j + 1)) j++;
            if (!less(list, i, j)) break;  // (i >= j)等价于!(i < j)，pass
            swap(list, i, j);

            i = j;
        }
    }

    private static boolean less(List<Map.Entry<String, Integer>> list, int i, int j) {

        return list.get(i-1).getValue() < list.get(j-1).getValue();
    }

    private static void swap(List<Map.Entry<String, Integer>> list, int i, int j) {

        Map.Entry<String, Integer> temp = list.get(i-1);
        list.set(i-1, list.get(j-1));
        list.set(j-1, temp);
    }
}
