public class Solution {
    public int trap(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = A[0];
        right[n - 1] = A[n - 1];
        
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i]);
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - A[i];
        }
        
        return sum;
    }
}