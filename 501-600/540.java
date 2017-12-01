---------------------My------------------------
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int k=1;
        int num=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(i==nums.length-1) return nums[i];
            if(num!=nums[i])
            {
                if(k==1) return num;
                if(k==2)
                {
                    num=nums[i];
                    k=1;
                }
            }
            else{
                num=nums[i];
                k++;
            }
        }
        return num;
    }
}
Explanation:
用两个变量分别记录上一个遍历的数字的值和出现的次数。
若上次的数字和这次的数字不同并且上次的数字计数为1，即为所求。
若上次的数字和这次的数字不同，但上次的数字计数为2，更新数字。
若上次的数字和这次的数字相同，计数+1。
若数字出现在最后，直接返回。