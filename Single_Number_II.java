public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int item : A) {
                if ((item >> i & 1) == 1) {
                    count = (count + 1) % 3;
                }
            }
            if (count == 1) {
                res += 1 << i;
            }
        }
        
        return res;
    }
}