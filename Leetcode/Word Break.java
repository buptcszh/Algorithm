public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // dp[i]表示以第i个字符结尾的字符串是否可以被分割
        // dp[i]=union{dp[j] && substring(j, i)}, j=0,1...i-1
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
// 划分出子问题，想好要保存哪些中间值，写出递推公式
