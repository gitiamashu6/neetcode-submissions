class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        int mid =0;
        while(l <= r) {
            mid = l + (int)Math.floor((r-l)/2);
            if(nums[mid] < nums[l]) r = mid;
            else if(nums[mid] > nums[r]) l = mid+1;
            else return nums[l];
        }
        return nums[mid];
    }
}
