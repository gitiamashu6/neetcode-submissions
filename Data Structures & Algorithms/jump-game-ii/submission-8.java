class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int count = 0;
        int current = 0;
        if (nums.length == 1)
            return count;
        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);
            if (maxJump >= nums.length - 1) {
                count++;
                break;
            }
            if (i == current) {
                count++;
                current = maxJump;
            }
        }
        return count;
    }
}
