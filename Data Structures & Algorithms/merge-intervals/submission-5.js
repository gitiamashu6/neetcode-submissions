class Solution {
    /**
     * @param {number[][]} intervals
     * @return {number[][]}
     */
    merge(intervals) {
        let res = [];
        let i = 0;
        intervals.sort((a,b) => a[0] - b[0]);
        for(let j = 1; j<intervals.length; j++){
            if(intervals[i][1] >= intervals[j][0]){
                intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            }
            else{
                res.push(intervals[i]);
                i = j;
            }
        }
        res.push(intervals[i]);
        return res;
    }
}