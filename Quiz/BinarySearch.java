public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 2, 3, 9};

        int pos = bsearch(nums, 2);
        System.out.println(pos);
    }

    public static int bsearch(int[] nums, int n) {
        int start = 0, end = nums.length - 1;

        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // 返回最左边的值
            if (nums[mid] == n) {
                res = mid;
                end = mid - 1;
            }
            else if (nums[mid] < n) start = mid + 1;
            else end = mid - 1;
        }

        return res;
    }
}