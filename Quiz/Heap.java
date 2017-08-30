/* NOT STABLE
 * pf: long-distance exchange might move an item past some equal item.
 */
 import java.util.Arrays;

 public class Heap {
     public static void main(String[] args) {
         int[] x = new int[]{100, 2, 5, 9, 1, 3, 7, 3, 9};

         sort(x);
         System.out.println(Arrays.toString(x));
     }

     private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 大根堆
    private static void sink(int[] nums, int p, int N) {
        while (2 * p <= N) {
            int k = 2 * p;

            if (k < N && nums[k] < nums[k + 1]) k++;
            
            if (nums[k] > nums[p]) {
                swap(nums, p, k);
                p = k;
            } else {
                break; // 不要忘记break
            }
        }
    }

    // 从nums[1]开始排序
    private static void sort(int[] nums) {
        int N = nums.length - 1;

        for (int i = N / 2; i >= 1; i--) {
            sink(nums, i, N);
        }

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }
 }
