public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        
        int res = 0;
        for (String str : tokens) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                stack.push( - stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                int after = stack.pop();
                stack.push(stack.pop() / after);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.pop();
        
    }
}