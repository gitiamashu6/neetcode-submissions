class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxCount = 0;
        for(int n : set) {
            int count =0;
            if(!set.contains(n-1)) {
                int i = n+1;
                count++;
                while(set.contains(i)) {
                    i++;
                    count++;
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
