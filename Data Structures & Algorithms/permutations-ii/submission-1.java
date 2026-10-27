class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permutationNum(nums, 0);
    }

    private List<List<Integer>> permutationNum(int[] r, int x) {
        Set<Integer> set = new HashSet<>();
        if (x + 1 == r.length) {
            result.add(Arrays.stream(r).boxed().toList());
            return result;
        }
        for (int i = x; i < r.length; i++) {
            if (set.add(r[i])) {
                int t = r[i];
                r[i] = r[x];
                r[x] = t;
                permutationNum(Arrays.copyOf(r, r.length), x + 1);
            }
        }

        return result;
    }
}