class Solution {
    private int[][] dp;
    
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        return recursion(s, 0, n - 1);
    }
    
    private int recursion(String s, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        
        int res;
        
        if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
            res = 2;
        }
        else if (j - i > 1 && s.charAt(i) == s.charAt(j)) {
            res = recursion(s, i + 1, j - 1) + 2;
        }
        else {
            res = Math.max(recursion(s, i + 1, j), recursion(s, i, j - 1));
        }
            
        dp[i][j] = res;
        return res; 
    }
}