class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(target - nums[i]);
        }
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i]))
                continue;
            if(nums[i] + list.get(list.lastIndexOf(target-nums[i])) == target && i != list.lastIndexOf(nums[i])) {
                result[0] = i;
            result[1] = list.lastIndexOf(nums[i]);
            break;
            }
            

        }
        return result;
    }
}
