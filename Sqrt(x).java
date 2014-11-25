public class Solution {
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (high * high == x) {
            return high;
        }
        return low;
    }
}