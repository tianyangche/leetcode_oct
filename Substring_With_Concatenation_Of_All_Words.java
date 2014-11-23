public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (L.length == 0 || S.length() < L.length * L[0].length()) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : L) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        
        for (int i = 0; i <= S.length() - L[0].length() * L.length; i++) {
            if (helper(S.substring(i, i + L[0].length() * L.length), new HashMap<String, Integer>(map), L)) {
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean helper(String s, HashMap<String, Integer> map, String[] L) {
        for (int i = 0; i < L.length; i++) {
            String str = s.substring(i * L[0].length(), (i + 1) * L[0].length());
            if (!map.containsKey(str) || map.get(str) == 0) {
                return false;
            } else {
                map.put(str, map.get(str) - 1);
            }
        }
        return true;
    }
}