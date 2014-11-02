public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length == 0)
            return 0;
        int index = 0;
        for(int i = 0; i < A.length; i ++){
            if(A[i] != elem)
                A[index++] = A[i];
        }
        return index;
    }
}