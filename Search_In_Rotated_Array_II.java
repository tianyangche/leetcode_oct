public class Solution {
    public boolean search(int[] A, int target) {
        if (A.length == 0) {
            return false;
        }
        
        int left = 0;
        int right = A.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return true;
            }
            
            if (A[left] < A[mid]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (A[mid] < A[left]) {
                if (A[mid] < target && target <= A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                left ++;
            }
        }
        
        if (A[left] == target) {
            return true;
        }
        if (A[right] == target) {
            return true;
        }
        
        return false;
    }
}