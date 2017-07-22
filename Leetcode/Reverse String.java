public class Solution {
    public String reverseString(String s) {
        
        char[] value = s.toCharArray();
        int n = s.length() - 1;  // n是最后一位的index
        for (int i = (n-1) >> 1; i >= 0; i--) {  // (n-1)/2是中间偏左那一位的index
            
            int k = n - i;
            char a = value[i];
            char b = value[k];
            value[k] = a;
            value[i] = b;
        }
        return new String(value);
    }
}