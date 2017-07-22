public class Solution {
    public int strStr(String haystack, String needle) {

        int h = haystack.length();
        int n = needle.length();

        if (n > h) return -1;

        for (int i = 0; i <= h - n; i++) {

            int j, k;
            for (j = i, k = 0; k < n; j++, k++) {

                if (haystack.charAt(j) != needle.charAt(k)) break;
            }

            if (k == n) return i;
        }

        return -1;
    }
}
