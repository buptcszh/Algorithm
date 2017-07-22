public class Solution {

    private String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return res;

        dfs(digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(String nums, int start, StringBuilder sb) {

        if (start == nums.length()) {

            res.add(sb.toString());
            return;
        }

        //if (nums.charAt(start) == '0' || nums.charAt(start) == '1') return;

        String x = map[nums.charAt(start) - '0'];
        for (int i = 0; i < x.length(); i++) {

            sb.append(x.charAt(i));
            dfs(nums, start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
