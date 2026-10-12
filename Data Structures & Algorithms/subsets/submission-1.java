class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        for (int i = 0; i < nums.length; i++) {
             resultSet(result, nums[i]);
        }
        return result;
    }

    private List<List<Integer>> resultSet(List<List<Integer>> result, int n) {
        int len = result.size();
        for(int i =0; i< len; i++) {
            List<Integer> l = new ArrayList<>(result.get(i));
            l.add(n);
            result.add(l);
        }
        return result;
    }
}
