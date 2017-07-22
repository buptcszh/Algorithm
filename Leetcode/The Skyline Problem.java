public class Solution {
    // 扫描线算法
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        // 分离出楼的起点和终点，终点用负数标记
        for (int[] b : buildings) {
            height.add(new int[]{b[0], b[2]});
            height.add(new int[]{b[1], -b[2]});
        }
        // 从小到大排序，从而开始扫描
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                // 如果一个楼的起点和另一个楼的终点重合，那么起点应排在终点前面
                else return b[1] - a[1];
            }
        });
        // 用大根堆来记录楼的最大高度
        Queue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        que.offer(0);
        int prev = 0;

        for (int[] x : height) {
            if (x[1] > 0) que.offer(x[1]);
            else que.remove(-x[1]);  // 遇到楼的终点，撤销这个楼的影响

            int max = que.peek();
            if (max != prev) {  // 楼高度的最大值发生变化
                result.add(new int[]{x[0], max});
                prev = max;
            }
        }

        return result;
    }
}
