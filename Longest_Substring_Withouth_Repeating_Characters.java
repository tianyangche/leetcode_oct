public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) < start) {
                map.put(c, i);
            } else {
                max = Math.max(max, i - start);
                start = map.get(c) + 1;
                map.put(c, i);
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
        
    }
}