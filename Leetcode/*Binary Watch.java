public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> l = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i * 64 + j) == num)
                    l.add(String.format("%d:%02d", i, j));  // %02表示宽度为2，不足的补0
            }
        }

        return l;
    }
}
