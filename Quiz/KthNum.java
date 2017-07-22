public class Solution {
    public static void main(String[] arg) {

        Solution s = new Solution();

        int[] nums = new int[]{1, 2, 4, 6, 3};
        System.out.println(s.find(nums, 5));
    }

    public int find(int[] nums, int k) {

        k = k - 1;
        int i = 0, j = nums.length-1;

        while (i <= j) {

            int pos = partition(nums, i, j);

            if (k > pos) i = pos + 1;
            else if (k < pos) j = pos - 1;
            else return nums[k];
        }

        return -1;
    }

    private int partition(int[] nums, int i, int j) {

        int pos = i;

        while (i < j) {

            while (i < j && nums[pos] <= nums[j]) j--;
            while (i < j && nums[pos] >= nums[i]) i++;

            swap(nums, i, j);
        }
        swap(nums, i, pos);

        return i;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
