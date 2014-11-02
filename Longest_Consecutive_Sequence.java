public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length < 2) {
            return num.length;
        }
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], true);
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            int curr = 1;
            int value = num[i] - 1;
            while (map.containsKey(value) && map.get(value)) {
                map.put(value, false);
                value--;
                curr++;
            }
            value = num[i] + 1;
            while (map.containsKey(value) && map.get(value)) {
                map.put(value, false);
                value++;
                curr++;
            }
            max = Math.max(max, curr);
        }
        
        return max;
    }
}