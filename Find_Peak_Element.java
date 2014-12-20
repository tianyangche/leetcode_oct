public class Solution {
    public int findPeakElement(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            } else if (num[mid] > num[mid - 1] && num[mid] < num[mid + 1]) {
                start = mid;
            } else if (num[mid] < num[mid - 1] && num[mid] > num[mid + 1]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        return num[start] > num[end] ? start : end;
    }
}