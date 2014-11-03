public class Solution {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuffer res = new StringBuffer();
        
        int i = 0;
        while (num != 0) {
            if (num - value[i] >= 0) {
                res.append(roman[i]);
                num -= value[i];
            } else {
                i++;
            }
        }
        return res.toString();
    }
}