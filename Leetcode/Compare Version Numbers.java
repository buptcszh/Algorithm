public class Solution {
    public int compareVersion(String version1, String version2) {

        String[] x = version1.split("\\.");
        String[] y = version2.split("\\.");

        int i, j;
        for (i = 0, j = 0; i < x.length && j < y.length; i++, j++) {

            if (Integer.valueOf(x[i]) > Integer.valueOf(y[i])) return 1;
            if (Integer.valueOf(x[i]) < Integer.valueOf(y[i])) return -1;
        }

        while (i < x.length) {

            if (Integer.valueOf(x[i]) != 0) return 1;
            i++;
        }
        while (j < y.length) {

            if (Integer.valueOf(y[j]) != 0) return -1;
            j++;
        }
        return 0;
    }
}
