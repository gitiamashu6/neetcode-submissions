/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <=1) return true;
        List<Interval> list =
            intervals.stream().sorted((a, b) -> Integer.compare(a.start, b.start)).toList();
            int start = list.get(0).start;
            int end = list.get(0).end;
        for (int i =1; i<list.size(); i++) {
            // System.out.println(i.start + " -> " + i.end);
            if(list.get(i).start < end) return false;
            else {
                start = list.get(i).start;
                end = list.get(i).end;
            }
        }
        return true;
    }
}
