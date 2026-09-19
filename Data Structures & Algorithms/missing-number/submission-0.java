class Solution {
    public int missingNumber(int[] nums) {
        int sumOfNums = Arrays.stream(nums).sum();
        int sumOfN= (nums.length*(nums.length+1)) / 2;
        return (sumOfN - sumOfNums);
    }
}
