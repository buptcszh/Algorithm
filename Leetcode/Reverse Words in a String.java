public class Solution {
    public String reverseWords(String s) {

        s = cleanSpace(s.toCharArray());
        if (s.length() == 0) return "";

        char[] res = s.toCharArray();
        reverse(res, 0, res.length - 1);

        int start = 0, end = 0;
        while (start < res.length) {

            while (end < res.length && res[end] != ' ') end++;
            reverse(res, start, end - 1);

            start = end + 1;
            end = start;
        }

        return new String(res);
    }

    private String cleanSpace(char[] s) {

        int last = 0;
        for (int i = 0; i < s.length; i++) {

            if (i > 0 && s[i] == ' ' && s[i - 1] == ' ') continue;
            s[last++] = s[i];
        }

        return new String(s).substring(0, last).trim();
    }

    private void reverse(char[] s, int start, int end) {

        while (start < end) {

            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
