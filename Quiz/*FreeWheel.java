public class Solution {
  private static String Solution(String num) {
    if (num == null || num.length() == 0) return num;

    char[] chs = num.toCharArray();
    int[] count = new int[9];

    for (int i = 0; i < chs.length; i++)
        count[chs[i] - '0']++;

    Stack<Character> stack = new Stack<>();
    stack.push(chs[0]);
    count[chs[0] - '0']--;

    for (int i = 1; i < chs.length; i++) {

        while (!stack.isEmpty() && stack.peek() >= chs[i] && count[stack.peek() - '0'] > 0)
            stack.pop();
        stack.push(chs[i]);
        count[chs[i] - '0']--;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < stack.size(); i++) sb.append(stack.get(i));
    return sb.toString();
  }
}
