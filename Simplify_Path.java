public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return path;
        } 
        
        String[] strs = path.split("/+");
        ArrayList<String> res = new ArrayList<String>();
        
        for (String curr : strs) {
            if (curr.equals("..")) {
                if (!res.isEmpty()) {
                    res.remove(res.size() - 1);
                }
            } else if (!curr.equals(".") && !curr.isEmpty()) {
                res.add(curr);
            }
        }
        
        StringBuffer buffer = new StringBuffer();
        if (res.size() == 0) {
            return "/";
        } else {
            for (String str : res) {
                buffer.append("/").append(str);
            }
        }
        
        return buffer.toString();
    }
}