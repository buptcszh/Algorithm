public class Solution {
    public static int MoreThanHalfNum_Solution(int[] nums) {

        int x = findKth(nums, nums.length / 2);

        if (check(nums, x)) return x;
        else return 0;
    }

    private static int findKth(int[] nums, int k) {

        int pos = partition(nums, 0, nums.length - 1);
        while (pos != k) {

            if (pos < k) pos = partition(nums, pos + 1, nums.length - 1);
            else pos = partition(nums, 0, pos - 1);
        }

        return nums[pos];
    }

    private static int partition(int[] nums, int lo, int hi) {

        int mid = lo + (hi - lo) / 2;
        int pivot = lo;

        while (lo < hi) {

            while (lo < hi && nums[hi] >= nums[pivot]) hi--;
            while (lo < hi && nums[lo] <= nums[pivot]) lo++;
            swap(nums, lo, hi);
        }
        swap(nums, lo, pivot);

        return lo;
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static boolean check(int[] nums, int num) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == num) count++;
        }

        return count * 2 > nums.length;
    }
}
