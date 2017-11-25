class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int previous=nums[0];
        int record=0;
        for(int i =1;i<nums.length;i++)
        {
            if(previous==nums[i])
            {
                record++;
            }
            else{
                previous=nums[i];
                nums[i-record]=nums[i];
            }
        }
        return nums.length-record;
    }
}
Explanation:
用一个变量记录上个数值，用另一个record记录数组中的重复次数。