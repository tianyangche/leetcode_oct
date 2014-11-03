public class Solution {
    public int romanToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        int value = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (map.get(a) < map.get(b)) {
                value -= map.get(a);
            } else {
                value += map.get(a);
            }
        }
        
        value += map.get(s.charAt(s.length() - 1));
        return value;
    }
}