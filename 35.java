class Solution {
    public int searchInsert(int[] nums, int target) {
            if(nums==null) return 0;
            for(int i=0;i<nums.length;i++)
        {
            if (target<=nums[i]) return i;
        }
        return nums.length;
    }
}