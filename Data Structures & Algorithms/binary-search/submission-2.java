class Solution {
    public int search(int[] nums, int target) {
        int l=0,r= nums.length-1;
        return binarySearch(l,r,nums,target);
    }

    private int binarySearch(int l, int r, int[] nums, int target) {
        while(l<=r) {
            int mid = l+ (int)Math.floor((r-l)/2);
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return -1;
    }
}
