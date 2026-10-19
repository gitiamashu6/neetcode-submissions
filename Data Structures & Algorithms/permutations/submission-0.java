class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        return permutationNum(nums, 0);
    }

    private List<List<Integer>> permutationNum(int[] r, int x) {
        if (x + 1 == r.length) {
            result.add(Arrays.stream(r).boxed().toList());
            return result;
        }
        for (int i = x; i < r.length; i++) {
            int t = r[i];
            r[i] = r[x];
            r[x] = t;
            permutationNum(Arrays.copyOf(r,r.length), x+1);
        }

        return result;
    }
}
