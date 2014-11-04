public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs.length == 0) {
            return res;
        }
        
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String curr : strs) {
            String hash = getHash(curr);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(curr);
        }
        
        for (ArrayList<String> list : map.values()) {
            if (list.size() > 1) {
                res.addAll(list);
            }
        }
        
        return res;
    }
    
    private String getHash(String input) {
        if (input.isEmpty()) {
            return input;
        }
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}