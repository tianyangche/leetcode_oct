public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.isEmpty()) {
            return true;
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
        return canBreak[n];
    }
}