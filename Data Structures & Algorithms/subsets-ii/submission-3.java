class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsetRec(nums, new ArrayList<>(), 0);
        return result;
    }

    private List<List<Integer>> subsetRec(int[] nums, List<Integer> output, int i) {
        if (nums.length < 1 || i >= nums.length) {
            result.add(output);
            return result;
        }
        subsetRec(
            Arrays.stream(nums).filter(a -> a != nums[0]).toArray(), new ArrayList(output), 0);
        output.add(nums[0]);
        subsetRec(Arrays.copyOfRange(nums, i + 1, nums.length), new ArrayList(output), 0);
        return result;
    }
}
