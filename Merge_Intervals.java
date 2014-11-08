/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            res = insert(res, intervals.get(i));
        }
        return res;
    }
    
    private List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }
        
        int i = 0;
        while (i < intervals.size()) {
            if (newInterval.start > intervals.get(i).end) {
                i++;
            } else if (newInterval.end < intervals.get(i).start) {
                intervals.add(i, newInterval);
                return intervals;
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                intervals.remove(i);
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}