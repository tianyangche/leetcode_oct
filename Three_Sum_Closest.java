public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int res = target + Integer.MAX_VALUE;
        for (int i = 0; i <= num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = num.length - 1;
            while (l < r) {
                int sum = num[i] + num[l] + num[r];
                if ( Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum == target) {
                    return sum;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }    
        return res;
    }
}