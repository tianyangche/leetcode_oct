public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        
        int index = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != A[index - 2]) {
                A[index++] = A[i];
            }
        }
        return index;
    }
}