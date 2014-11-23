public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int beginX = 0;
        int endX = matrix[0].length - 1;
        int beginY = 0;
        int endY = matrix.length - 1;
        while (true) {
            for (int i = beginX; i <= endX; i++) {
                res.add(matrix[beginY][i]);
            }
            if (++beginY > endY) {
                break;
            }
            for (int i = beginY; i <= endY; i++) {
                res.add(matrix[i][endX]);
            }
            if (--endX < beginX) {
                break;
            }
            for (int i = endX; i >= beginX; i--) {
                res.add(matrix[endY][i]);
            }
            if (--endY < beginY) {
                break;
            }
            for (int i = endY; i >= beginY; i--) {
                res.add(matrix[i][beginX]);
            }
            if (++beginX > endX){
                break;
            }
        }
        return res;
    }
}