/* NOT STABLE
 * pf: long-distance exchanges.
 */
public class Shell
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

		int h = 1;
		while (h < N/3) h = h*3 + 1;  // 3x+1 increment sequence

		while (h >= 1)
		{
			// h-sort the array
			for (int i = h; i < N; i++)
				for (int j = i; j >= h; j -= h)
					if (less(a[j], a[j-h])) exch(a, j, j-h);
					else break;

			h = h/3;
		}
	}

	public static void main(String[] args)
	{ /* test */ }
}
