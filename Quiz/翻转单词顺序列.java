public class Solution {
    public String ReverseSentence(String str) {

        if (str == null || str.length() == 0) return str;

        char[] chs = str.toCharArray();
        reverseWord(chs, 0, chs.length - 1);

        int start = 0, end = 0;
        while (start < chs.length) {

            while (start < chs.length && chs[start] == ' ') start++;
            end = start;
            while (end < chs.length && chs[end] != ' ') end++;
            end -= 1;
            reverseWord(chs, start, end);
            start = end + 1;
        }

        return new String(chs);
    }

    private void reverseWord(char[] chs, int start, int end) {

        if (start >= end) return;

        while (start < end) {

            char temp = chs[start];
            chs[start++] = chs[end];
            chs[end--] = temp;
        }
    }
}
