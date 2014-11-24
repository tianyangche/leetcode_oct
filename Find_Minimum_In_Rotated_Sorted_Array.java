public class Solution {
    public int findMin(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid != 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            } else if (num[mid] > num[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return Math.min(num[start], num[end]);
    }
}