public class Solution {
    public int InversePairs(int[] array) {

        int[] aux = new int[array.length];
        return sort(array, aux, 0, array.length - 1);
    }

    private int sort(int[] array, int[] aux, int start, int end) {

        if (start >= end) return 0;

        int mid = start + (end - start) / 2;

        int left = sort(array, aux, start, mid);
        int right = sort(array, aux, mid + 1, end);

        int m = merge(array, aux, start, mid, end);

        return (left + right + m) % 1000000007;
    }

    private int merge(int[] array, int[] aux, int start, int mid, int end) {

        System.arraycopy(array, start, aux, start, end - start + 1);

        int count = 0;
        int i = mid, j = end, k = end;

        while (i >= start && j >= mid + 1) {

            if (aux[i] < aux[j]) array[k--] = aux[j--];
            else if (aux[i] > aux[j]) {

                count += j - mid;
                array[k--] = aux[i--];

                if (count >= 1000000007) count %= 1000000007;  // important
            }
        }

        while (i >= start) array[k--] = aux[i--];
        while (j >= mid + 1) array[k--] = aux[j--];

        return count;
    }
}
