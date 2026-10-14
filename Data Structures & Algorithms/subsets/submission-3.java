class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        return subsetRec(nums, new ArrayList(), 0);
    }

    private List<List<Integer>> subsetRec(int[] nums, List<Integer> output, int i) {
        if (nums.length < 1) {
            result.add(output);
            return result;
        }
        subsetRec(Arrays.copyOfRange(nums, i + 1, nums.length), new ArrayList(output), 0);
        output.add(nums[0]);
        subsetRec(Arrays.copyOfRange(nums, i + 1, nums.length), new ArrayList(output), 0);
        return result;
    }
}
