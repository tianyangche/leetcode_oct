public class Solution {
    public int compareVersion(String version1, String version2) {
        int res = 0;
        int dot1 = 0;
        int dot2 = 0;
        int a = 0;
        int b = 0;
        while (res == 0 && (dot1 >= 0 || dot2 >= 0)) {
            dot1 = version1.indexOf('.');
            dot2 = version2.indexOf('.');
            if (dot1 < 0) {
                a = Integer.parseInt(version1);
                version1 = "0";
            } else {
                a = Integer.parseInt(version1.substring(0, dot1));
                version1 = version1.substring(dot1 + 1);
            }
            if (dot2 < 0) {
                b = Integer.parseInt(version2);
                version2 = "0";
            } else {
                b = Integer.parseInt(version2.substring(0, dot2));
                version2 = version2.substring(dot2 + 1);
            }
            res = compareNumbers(a, b);
        }
        return res;
    }
    private int compareNumbers(int a, int b) {
        if (a == b) {
            return 0;
        }
        return a > b ? 1 : -1;
    }
}