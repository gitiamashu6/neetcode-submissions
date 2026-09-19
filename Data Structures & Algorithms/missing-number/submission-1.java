class Solution {
    public int missingNumber(int[] nums) {
        int sumOfNums = Arrays.stream(nums).sum();
        int len = nums.length;
        int sumOfN= (len*(len+1)) / 2;
        return (sumOfN - sumOfNums);
    }
}
