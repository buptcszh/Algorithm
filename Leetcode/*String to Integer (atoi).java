public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        
        int sign = 1, base = 0, i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }
        
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base = base * 10 + str.charAt(i++) - '0';
        }
        
        return base * sign;
    }
}