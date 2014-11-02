public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i <= num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = num.length - 1;
            while (l < r) {
                if (num[i] + num[l] + num[r] == 0) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[l]);
                    temp.add(num[r]);
                    res.add(temp);
                    do {
                        l++;
                    } while (l < r && num[l] == num[l - 1]);
                    do {
                        r--;
                    } while (r > l && num[r] == num[r + 1]);
                } else if (num[i] + num[l] + num[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}