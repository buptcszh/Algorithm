public class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        int last = 0, cur;

        for(int i = n - 1; i >= 0; --i) {
            switch(s.charAt(i)) {
                case 'I': cur = 1; break;
                case 'V': cur = 5; break;
                case 'X': cur = 10; break;
                case 'L': cur = 50; break;
                case 'C': cur = 100; break;
                case 'D': cur = 500; break;
                default: cur = 1000;
            }

            if(cur >= last) res += cur;
            else res -= cur;
            last = cur;
        }
        return res;
    }
}
