/* NOT STABLE
 * pf: long-distance exchange might move an item past some equal item.
 * algorithm goes QUADRATIC unless partitioning stops on equal keys.
 */
 import java.util.Arrays;

 public class Quick {
     public static void main(String[] args) {
         int[] x = new int[]{2, 5, 9, 1, 3, 7};

         sort(x, 0, x.length - 1);
         System.out.println(Arrays.toString(x));
     }

     private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];

        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            swap(nums, i, j);
        }
        swap(nums, start, i);

        return i;
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) return;

        int pos = partition(nums, start, end);
        sort(nums, start, pos - 1);
        sort(nums, pos + 1, end);
    }
 }
