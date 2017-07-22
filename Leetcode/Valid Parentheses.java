public class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 2 != 0) return false;
        
        Stack<Character> sc = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') sc.push(s.charAt(i));
            else if (s.charAt(i) == ')' && !sc.isEmpty() && sc.peek() == '(') sc.pop();
            else if (s.charAt(i) == ']' && !sc.isEmpty() && sc.peek() == '[') sc.pop();
            else if (s.charAt(i) == '}' && !sc.isEmpty() && sc.peek() == '{') sc.pop();
            else return false;
        }
        
        return sc.isEmpty();
    }
}