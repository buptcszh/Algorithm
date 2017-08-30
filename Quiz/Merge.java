/* STABLE
 * pf: merge takes from left subarray if equal keys.
 */
 import java.util.Arrays;

 public class Merge {
     public static void main(String[] args) {
         int[] x = new int[]{2, 5, 9, 1, 3, 7, 3, 9};

         int[] aux = new int[x.length];  // 辅助数组放在main中定义
         
         sort(x, aux, 0, x.length - 1);
         System.out.println(Arrays.toString(x));
     }

     private static void merge(int[] nums, int[] aux, int start, int mid, int end) {
        System.arraycopy(nums, start, aux, start, end - start + 1); // merge先copy数组

        int i = start, j = mid + 1, k = start;

        while (i <= mid && j <= end) {
            if (aux[i] < aux[j]) nums[k++] = aux[i++];
            else nums[k++] = aux[j++];
        }

        while (i <= mid) {
            nums[k++] = aux[i++];
        }

        while (j <= end) {
            nums[k++] = aux[j++];
        }
    }

    public static void sort(int[] nums, int[] aux, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        sort(nums, aux, start, mid);
        sort(nums, aux, mid + 1, end);

        merge(nums, aux, start, mid, end);
    }
 }
