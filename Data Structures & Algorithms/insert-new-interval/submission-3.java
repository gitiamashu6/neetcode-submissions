class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (start <= intervals[i][1] && end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
                start = Math.min(start, intervals[i][0]);
            } else {
                if (start < intervals[i][0]) {
                    result.add(new int[] {start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
                else
                    result.add(new int[] {intervals[i][0], intervals[i][1]});
            }
        }
        result.add(new int[] {start, end});
        return result.toArray(new int[result.size()][]);
    }
}
