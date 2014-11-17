public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        if (A == null || A.length == 0) {
            return res;
        }
        int left = 0;
        int right = A.length - 1;

        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (A[right] == target) {
            res[0] = right;
        }
        if (A[left] == target) {
            res[0] = left;
        }
        
        left = 0;
        right = A.length - 1;
        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }        
        
        if (A[left] == target) {
            res[1] = left;
        }
        if (A[right] == target) {
            res[1] = right;
        }
        
        return res;
    }

}