public class Solution {
    public void sort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int x = stack.pop();  // 弹栈

            // 将x和temp的栈顶元素比较
            while (!temp.isEmpty() && x < temp.peek()) {
                stack.push(temp.pop());
            }
            temp.push(x);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}