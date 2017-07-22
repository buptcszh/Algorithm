/* STABLE
 * pf: equal items never move past each other.
 */
public class Insertion
{
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static boolean less(Comparable x, Comparable y)
	{
		return x.compareTo(y) < 0;
	}

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for (int i = 0; i < N; i++)
			// 类似bubble
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j-1])) exch(a, j, j-1);
				else break;
	}

	public static void main(String[] args)
	{ /* test */ }
}
