/* NOT STABLE
 * pf: long-distance exchange might move an item past some equal item.
 */
public class Selection
{
    private static boolean less(Comparable i, Comparable j)
    {
        return i.compareTo(j) < 0;
    }

    private static void exch(Comparable[] key, int i, int j)
    {
        Comparable temp = key[i];
        key[i] = key[j];
        key[j] = temp;
    }

    public static void sort(Comparable[] key)
    {
        int N = key.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(key[j], key[min])) min = j;
            exch(key, i, min);
        }
    }

    public static void main(String[] args)
    { /* test */ }
}
