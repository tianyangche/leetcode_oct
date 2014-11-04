public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isMatch(char l, char r) {
        if ((l == '(' && r == ')') || (l == '[' && r == ']') || (l == '{' && r == '}')) {
            return true;
        }
        return false;
    }
}