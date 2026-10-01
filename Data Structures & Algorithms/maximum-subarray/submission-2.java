class Solution {
    public int maxSubArray(int[] nums) {
        // if(nums.length == 1) return nums[0];
        int maxSum = Integer.MIN_VALUE, sum = 0, l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];
            maxSum = Math.max(maxSum,sum);
            if (sum < 0) {
                sum = 0;
                r++;
                l=r;
            } else
                r++;
        }
        return maxSum;
    }
}
