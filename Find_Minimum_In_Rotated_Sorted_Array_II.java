public class Solution {
    public int findMin(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        
        for (int i = 0; i < num.length - 1; i ++) {
            if (num[i] > num[i + 1]) {
                return num[i + 1];
            }
        }
        
        return num[0];
    }
}