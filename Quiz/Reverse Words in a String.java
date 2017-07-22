public class Solution {
    // 保留原始的空格
    public String reverseWords(String s) {

      char[] res = s.toCharArray();
      reverse(res, 0, res.length - 1);

      int start = 0, end = 0;
      while (start < res.length) {

         while (start < res.length && res[start] == ' ') start++;

         end = start + 1;
         while (end < res.length && res[end] != ' ') end++;

         reverse(res, start, end - 1);
         start = end + 1;
      }

      return new String(res);
    }

    private void reverse(char[] s, int start, int end) {

        if (start >= s.length) return;

        while (start < end) {

            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
