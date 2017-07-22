/* STABLE
 * pf: merge takes from left subarray if equal keys.
 */
 import java.util.Arrays;

 public class Merge {
     public static void main(String[] args) {
         int[] x = new int[]{2, 5, 9, 1, 3, 7, 3, 9};

         int[] aux = new int[x.length];  // 辅助数组不要放在递归里
         sort(x, aux, 0, x.length - 1);
         System.out.println(Arrays.toString(x));
     }

     private static void merge(int[] num, int[] aux, int begin, int mid, int end) {

         System.arraycopy(num, begin, aux, begin, end - begin + 1);

         int i = begin, j = mid + 1, k = begin;
         while (i <= mid && j <= end) {

             if (aux[i] < aux[j])
                 num[k++] = aux[i++];
             else
                 num[k++] = aux[j++];
         }

         while (i <= mid) num[k++] = aux[i++];
         while (j <= end) num[k++] = aux[j++];
     }

		 public static void sort(int[] num, int[] aux, int begin, int end) {

				 if (begin >= end) return;

				 int mid = begin + (end - begin) / 2;

				 sort(num, aux, begin, mid);
				 sort(num, aux, mid + 1, end);
				 merge(num, aux, begin, mid, end);
		 }
 }
