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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() < 1) return 0;
        intervals.sort((a,b)-> Integer.compare(a.start,b.start));
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(Interval interval : intervals) {
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start) minHeap.poll();
            minHeap.add(interval.end);
        }
        return minHeap.size();
    }
}
