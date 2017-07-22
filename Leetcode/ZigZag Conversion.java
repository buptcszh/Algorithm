public class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;
        
        int len = s.length();
        char[] c = new char[len];
        int dis = 2*(numRows - 1);
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            
            for (int j = i; j < len; j += dis) {
                
                c[k++] = s.charAt(j);
                if (i > 0 && i < numRows - 1 && j + dis - 2*i < len)
                    c[k++] = s.charAt(j + dis - 2*i);
            }
        }
        return new String(c);
    }
}