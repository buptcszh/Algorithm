class Solution {
    private int res = 0;
    
    public int countSubstrings(String s) {
        // 以[i]为中心，计算奇数长度的回文串个数
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
        }
        
        // 以[i,i+1]为中心，计算偶数长度的回文串个数
        for (int i = 0; i < s.length() - 1; i++) {
            extend(s, i, i + 1);
        }
        
        return res;
    }
    
    private void extend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            res++;
            i--;
            j++;
        }
    }
}