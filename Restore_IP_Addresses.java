public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        List<String> parts = new ArrayList<String>();
        if (s.isEmpty()) {
            return res;
        }
        helper(res, parts, s, 0);
        return res;
    }
    private void helper(List<String> res, List<String> parts, String s, int index) {
        if (index == 4) {
            if (s.isEmpty()) {
                res.add(convert(parts));
            }
            return;
        }
        if (s.length() < 4 - index || s.length() > (4 - index) * 3) {
            return;
        }
        int boundary = Math.min(s.length(), 3);
        for (int i = 1; i <= boundary; i++) {
            String first = s.substring(0, i);
            if (isValid(first)) {
                parts.add(first);
                helper(res, parts, s.substring(i), index + 1);
                parts.remove(parts.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int value = Integer.parseInt(s);
        if (value >= 256 || (value == 0 && s.length() > 1) || (value != 0 && s.charAt(0) == '0')) {
            return false;
        }
        return true;
    }
    
    private String convert(List<String> parts) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <= 2; i ++) {
            buffer.append(parts.get(i));
            buffer.append(".");
        }
        buffer.append(parts.get(3));
        return buffer.toString();
    }
}