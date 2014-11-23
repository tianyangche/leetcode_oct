public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        ArrayList<String> partition = new ArrayList<String>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        
        int n = s.length();
        boolean[] canBreak = new boolean[n + 1];
        Arrays.fill(canBreak, false);
        canBreak[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        if (!canBreak[n]) {
            return res;
        }
        
        helper(res, partition, s, dict, 0);
        return res;
    }
    private void helper(List<String> res, ArrayList<String> partition, String s, Set<String> dict, int pos) {
        if (pos == s.length()) {
            res.add(convert(s, partition));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String first = s.substring(pos, i + 1);
            if (!dict.contains(first)) {
                continue;
            }
            partition.add(first);
            helper(res, partition, s, dict, i + 1);
            partition.remove(partition.size() - 1);
        }
    }
    
    private String convert(String s, ArrayList<String> partition) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < partition.size() - 1; i++) {
            buffer.append(partition.get(i)).append(" ");
        }
        buffer.append(partition.get(partition.size() - 1));
        return buffer.toString();
    }
}