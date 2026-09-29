class Solution {
    public boolean canJump(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        if (nums.length == 1)
            return true;
        // if(nums[0] == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, nums[i] + i);

            if (maxLen == nums[i] + i && nums[i] == 0)
                return false;
            if (maxLen >= nums.length - 1)
                return true;
        }
        return false;
    }
}
