public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 用hash表记录每个字符最近出现的位置
        Map<Character, Integer> m = new HashMap<>();

        int max = 0;
        // start表示字串的起始位置
        for (int i = 0, start = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                // start标记一个子串的开始
                // 如果重复字符出现在start之后，说明这个子串已经结束，更新start的位置
                start = Math.max(start, m.get(s.charAt(i)) + 1);
            }
            m.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
