public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        char[] c = strs[0].toCharArray();
        char[] d;
        for (int i = 0; i < c.length; i++) {
            
            for (int j = 1; j < strs.length; j++) {
                
                d = strs[j].toCharArray();
                if (i >= d.length || c[i] != d[i]) return sb.toString();
            }
            sb.append(c[i]);
        }
        return sb.toString();
    }
}