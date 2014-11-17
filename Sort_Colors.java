public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        
        int zero = 0;
        int one = 0;
        int two = A.length - 1;
        while (one <= two) {
            if (A[one] == 0) {
                swap(A, one++, zero++);
            } else if (A[one] == 2) {
                swap(A, one, two--);
            } else {
                one++;
            }
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}