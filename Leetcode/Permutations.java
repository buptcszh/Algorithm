public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] x, int start) {
        if (start == x.length - 1) {
            List<Integer> elem = new ArrayList<>();
            for (int num : x) elem.add(num);
            res.add(elem);
            return;
        }

        // 把第i个数作为开头，然后递归求后边的全排列
        for (int i = start; i < x.length; i++) {
            swap(x, start, i);
            backtracking(x, start + 1);
            swap(x, i, start);
        }
    }

    private void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}
