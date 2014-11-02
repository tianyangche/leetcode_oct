public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length < 2)
            return ;
        for(int i = num.length - 2; i >= 0; i --){
            if(num[i] < num[i + 1]){
                for(int j = num.length - 1; j > i; j --){
                    if(num[j] > num[i]){
                        swap(num, i, j);
                        reverse(num, i + 1, num.length - 1);
                        return ;
                    }
                }
                reverse(num, i, num.length - 1);
                return;
            }
        }
        reverse(num, 0, num.length - 1);
    }
    public void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void reverse(int[] num, int i, int j){
        while(i < j)
            swap(num, i++, j --);
    }

}