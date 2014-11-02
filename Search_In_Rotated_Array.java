public class Solution {
    public int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if (A[middle] == target) {
                return middle;
            }
            if (A[start] < A[middle]) {
                if (A[start] <= target && target < A[middle]) {
                    end = middle;
                } else {
                    start = middle;
                }
            } else {
                if (A[middle] < target && target <= A[end]) {
                    start = middle;
                } else {
                    end = middle;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        
        return -1;
        
    }
}