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

     private static void exch(int[] num, int i, int j) {

         int temp = num[i];
         num[i] = num[j];
         num[j] = temp;
     }

     private static int partition(int[] num, int begin, int end) {

         int pivot = num[begin];
         int i = begin, j = end;

         while (i < j) {

             while (i < j && num[j] >= pivot) j--;
             while (i < j && num[i] <= pivot) i++;
             exch(num, i, j);
         }
         exch(num, begin, i);

         return i;
     }

		 public static void sort(int[] num, int begin, int end) {

				 if (begin >= end) return;

				 int pos = partition(num, begin, end);
				 sort(num, begin, pos - 1);
				 sort(num, pos + 1, end);
		 }
 }
