class Solution {
    public int findDuplicate(int[] nums) {
        int high=nums.length-1;
        int low=1;
        int mid;
        while(low<high)
        {
            mid=(low+high)/2;
            int count=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]<=mid)
                    count++;
            }
            if(count>mid) high=mid;
            else low=mid+1;
        }
        return low;
    
            
    }
}