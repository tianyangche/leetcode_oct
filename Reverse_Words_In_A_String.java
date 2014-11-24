public class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        if (str == null || str.equals("")) {
            return str;
        }
        
        String[] arr = str.split("\\s+");
        
        StringBuffer buffer = new StringBuffer();
        
        for (int i = arr.length - 1; i > 0; i--) {
            buffer.append(arr[i]);
            buffer.append(" ");
        }
        
        buffer.append(arr[0]);
        return buffer.toString();
    }



}