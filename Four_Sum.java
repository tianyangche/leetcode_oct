public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i ++){
            if(i > 0 && num[i] == num[i - 1]) continue;
            for(int j = i + 1; j < num.length; j ++){
                if(j > i + 1 && num[j] == num[j - 1] ) continue;
                int m = j + 1, n = num.length - 1;
                while(m < n){
                    int sum = num[i] + num[j] + num[m] + num[n];
                    if(target == sum){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[m]);
                        temp.add(num[n]);
                        result.add(temp);
                        m ++;
                        n --;
                        while(m < n && num[m] == num[m - 1]) m ++;
                        while(m < n && num[n] == num[n + 1]) n --;
                    } else if(sum < target){
                        m ++;
                    } else
                        n --;
                }
            }
        }
        return result;
    }
}