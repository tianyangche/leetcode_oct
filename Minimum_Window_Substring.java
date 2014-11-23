public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || S.isEmpty()) {
            return S;
        }
        if (T == null || T.isEmpty()) {
            return T;
        }
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (!dict.containsKey(c)) {
                dict.put(c, 1);
            } else {
                dict.put(c, dict.get(c) + 1);
            }
        }
        
        int left = 0;
        int index = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!dict.containsKey(c)) {
                continue;
            }
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            if (map.get(c) <= dict.get(c)) {
                count++;
            }
            
            if (count == T.length()) {
                while (left <= i) {
                    char d = S.charAt(left);
                    if (!dict.containsKey(d)) {
                        left++;
                        continue;
                    }
                    if (map.get(d) > dict.get(d)) {
                        map.put(d, map.get(d) - 1);
                        left++;
                        continue;
                    }
                    break;
                }
                if (len > i - left + 1) {
                    len = i - left + 1;
                    index = left;
                }
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        } else {
            return S.substring(index, index + len);
        }
    }
}
