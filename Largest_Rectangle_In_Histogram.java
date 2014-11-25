public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int currHeight = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= currHeight) {
                int hei = height[stack.pop()];
                int pos = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, hei * pos);
            }
            stack.push(i);
        }
        return max;
    }

}