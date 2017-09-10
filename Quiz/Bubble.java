/* NOT STABLE
 * pf: long-distance exchange might move an item past some equal item.
 */
import java.util.*;

public class Bubble {	
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 0, 9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean moved = false;
            
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    moved = true;
                }
            }
            
            if (!moved) break;  // 没有移动过，则停止
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
