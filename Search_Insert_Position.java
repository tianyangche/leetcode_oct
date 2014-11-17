public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = A.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                right = mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (A[left] >= target) {
            return left;
        }
        
        if (A[left] < target && target <= A[right]) {
            return right;
        }
        
        return right + 1;
        
        
    }
}