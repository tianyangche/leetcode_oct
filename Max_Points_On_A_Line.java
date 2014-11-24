/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            int same = 1;
            max = 0;
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                } else {
                    int slope = getSlope(points[i], points[j]);
                    if (!map.containsKey(slope)) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                    max = Math.max(max, map.get(slope));
                }
                res = Math.max(res, max + same);
            }
        }
        return res;
    }
    private int getSlope(Point p, Point q) {
        if (p.x == q.x) {
            return Integer.MIN_VALUE;
        }
        if (p.y == q.y) {
            return 0;
        }
        int slope = (int) (10000 * (double)(p.y - q.y) / (double)(p.x - q.x));
        return slope;
    }
}