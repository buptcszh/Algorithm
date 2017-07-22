import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length) return res;

        int N = input.length;
        int[] nums = new int[N + 1];
        System.arraycopy(input, 0, nums, 1, N);

        for (int i = N / 2; i >= 1; i--) {

            sink(nums, i, N);
        }

        for (int i = 0; i < k; i++) {

            swap(nums, 1, N);
            res.add(nums[N--]);
            sink(nums, 1, N);
        }

        return res;
    }

    private void sink(int[] nums, int k, int N) {

        while (2 * k <= N) {

            int n = 2 * k;
            if (n + 1 <= N && nums[n] > nums[n + 1]) n++;
            if (nums[k] > nums[n]) swap(nums, n, k);
            k = n;
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
