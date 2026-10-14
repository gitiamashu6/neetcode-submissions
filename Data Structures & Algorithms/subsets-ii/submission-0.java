class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetRec(result, nums, new ArrayList<>(),0);
        return result;
    }

    private List<List<Integer>> subsetRec(
        List<List<Integer>> result, int[] nums, List<Integer> output, int i) {
        if (nums.length < 1 || i >= nums.length) {
            result.add(output);
            return result;
        }
        int n = nums[i];
        subsetRec(result, Arrays.stream(nums).filter(a -> a != n).toArray(), new ArrayList(output),0);
        output.add(n);
        i++;
        subsetRec(result, Arrays.copyOfRange(nums, i, nums.length), new ArrayList(output),0);
        return result;
    }
}
