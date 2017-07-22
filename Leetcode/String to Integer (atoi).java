public class Solution {
    public int myAtoi(String str) {
        int i = 0, res = 0, sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (i < str.length()) {
            if (str.charAt(i) == '+') i++;
            else if (str.charAt(i) == '-') {
                sign = -1;
                i++;
            }
        }

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            if (res > Integer.MAX_VALUE / 10 ||
               (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }

            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }

        return sign * res;
    }
}
