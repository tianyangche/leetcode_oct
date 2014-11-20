public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        
        int n = triangle.size();
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            path[i] = triangle.get(n - 1).get(i);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                path[j] = Math.min(path[j], path[j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return path[0];
    }
}