class Solution {
    // 1. Use two pointers: start and end to represent a window.
    // 2. Move end to find a valid window.
    // 3. When a valid window is found, move start to find a smaller window.
    public String minWindow(String s, String t) {
        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int counter = t.length();
        
        int[] count = new int[256];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }
        
        while (end < s.length()) {
            if (count[s.charAt(end)] > 0) {
                counter--;
            }
            count[s.charAt(end)]--;
            end++;
            
            while (counter == 0) {
                if (end - start < minLen) {  // 已经执行过end++了
                    minLen = end - start;
                    minStart = start;
                }
                
                count[s.charAt(start)]++;
                if (count[s.charAt(start)] > 0) {
                    counter++;
                }
                start++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);  // begin~end-1
    }
}