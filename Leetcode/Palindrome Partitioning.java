public class Solution {
    List<List<String>> res = new ArrayList<>();
    ArrayList<String> cur = new ArrayList<>();  // 这里不能声明接口，否则不能调用clone方法

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    // start标记深搜的起始位置
    private void dfs(String s, int start) {

        if (start == s.length() && cur.size() > 0)
            res.add((ArrayList<String>) cur.clone());  // 对于String来说，就是深拷贝了

        for (int i = start; i < s.length(); i++) {

            String x = s.substring(start, i+1);
            if (isPalindrome(x)) {
                cur.add(x);
                dfs(s, i+1);
                cur.remove(cur.size() - 1);  // 回溯
            }
        }
    }

    private boolean isPalindrome(String x) {
        int i = 0, j = x.length() - 1;
        while (i < j) {
            if (x.charAt(i) == x.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}
