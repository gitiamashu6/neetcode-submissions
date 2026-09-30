class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int count = 0;
        if(nums.length == 1) return count;
        for (int i = 0; i < nums.length; i++) {
            if (maxJump >= nums[i] + i || nums[maxJump] + maxJump > nums[i] + i)
                continue;
            maxJump = Math.max(maxJump,nums[i]+i);
            count++;
            if (maxJump >= nums.length - 1) 
                break;
        }
        return count;
    }
}
