class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (nums[mid] < nums[l])
                r = mid;
            else if (nums[mid] > nums[r])
                l = mid + 1;
            else {
                if (target >= nums[l] && target <= nums[nums.length - 1])
                    return binarySearch(l, nums.length - 1, nums, target);

                else
                    return binarySearch(0, l - 1, nums, target);
            }
        }
        return -1;
    }

    private int binarySearch(int l, int r, int[] a, int t) {
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (a[mid] == t) {
                return mid;
            } else if (t > a[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
