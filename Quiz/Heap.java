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

     private static void exch(int[] num, int i, int j) {

         int temp = num[i];
         num[i] = num[j];
         num[j] = temp;
     }

     private static void sink(int[] num, int pos, int end) {

         while (2 * pos <= end) {

             int max = 2 * pos;
             if (max < end && num[max + 1] > num[max]) max++;

             if (num[max] > num[pos]) {

                 exch(num, max, pos);
                 pos = max;
             } else break;
         }
     }

     public static void sort(int[] num) {

         int N = num.length - 1;
         for (int i = N / 2; i >= 1; i--) {

             sink(num, i, N);
         }

         while (N > 1) {
             exch(num, 1, N--);
             sink(num, 1, N);
         }
     }
 }
