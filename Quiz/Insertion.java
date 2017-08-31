/* STABLE
 * pf: equal items never move past each other.
 */
public class Insertion {
	public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 0, 9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) swap(nums, j, j - 1);  // 让j和j-1进行比较
                else break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}