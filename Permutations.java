public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        Arrays.fill(visited, false);
        helper(res, curr, num, visited);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr, int[] num, boolean[] visited) {
        if (curr.size() == num.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            curr.add(num[i]);
            helper(res, curr, num, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}