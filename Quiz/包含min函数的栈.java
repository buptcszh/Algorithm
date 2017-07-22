import java.util.Stack;

public class Solution {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {

        stack.push(node);

        if (min.isEmpty()) min.push(node);
        else min.push(node < min.peek() ? node : min.peek());
    }

    public void pop() {

        stack.pop();
        min.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int min() {

        return min.peek();
    }
}
