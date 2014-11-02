public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if (total % 2 == 1) {
            return helper(A, 0, m, B, 0, n, total / 2 + 1);
        } else {
            return ( helper(A, 0, m, B, 0, n, total / 2) + helper(A, 0, m, B, 0, n, total / 2 + 1) ) / 2.0;
        }
    }
    
    private int helper(int[] A, int a, int m, int[] B, int b, int n, int len) {
        if (m > n) {
            return helper(B, b, n, A, a, m, len);
        }
        
        if (m == 0) {
            return B[b + len - 1];
        }
        
        if (len == 1) {
            return Math.min(A[a], B[b]);
        }
        
        int mm = Math.min(len / 2, m);
        int nn = len - mm;
        
        if (A[a + mm - 1] < B[b + nn - 1]) {
            return helper(A, a + mm, m - mm, B, b, n, len - mm);
        } else {
            return helper(A, a, m, B, b + nn, n - nn, len - nn);
        }
        
    }
}