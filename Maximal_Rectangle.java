public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        int max = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            max = Math.max(max, helper(heights));
        }
        return max;
    }
    
    
    private int helper(int[] height) {
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