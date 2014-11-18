public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length == 0) {
            return res;
        }
        
        Arrays.sort(num);
        List<Integer> curr = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        Arrays.fill(visited, false);
        helper(res, curr, num, visited);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] num, boolean[] visited) {
        if (curr.size() == num.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < num.length; i ++) {
            if (visited[i] || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == false)) {
                continue;
            }
            
            curr.add(num[i]);
            visited[i] = true;
            helper(res, curr, num, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

}