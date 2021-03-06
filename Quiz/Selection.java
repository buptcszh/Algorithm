/* NOT STABLE
 * pf: long-distance exchange might move an item past some equal item.
 */
import java.util.*;

public class Selection {	
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 0, 9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            swap(nums, i, min);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
