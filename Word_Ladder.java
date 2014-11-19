public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int distance = 2;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] str = curr.toCharArray();
                        if (str[j] == c) {
                            continue;
                        }
                        str[j] = c;
                        String temp = new String(str);
                        if (temp.equals(end)) {
                            return distance;
                        }
                        if (dict.contains(temp)) {
                            queue.offer(temp);
                            dict.remove(temp);
                        }
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}