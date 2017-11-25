class Solution {
    int record=0;
    public int findTargetSumWays(int[] nums, int S) {
        return recoedWays(nums,S,nums.length);
    }
    public int  recoedWays(int[]nums,int target,int n)
    {
        if(n>0)
        {
            return recoedWays(nums,target-nums[n-1],n-1)+recoedWays(nums,target+nums[n-1],n-1);
        }
        if(n==0&&target==0)
        {
            return 1;
        }
        else {
            return 0;
        }
        
    }
}
Explanation:
题目是给定数组,然后元素间添加+,-号使得算式结果等于目标值。可以用动态规划的思想来做。
假设B(n,S)是以索引n位置结束，最后结果为S的情况数量，即题目所求。因为符号只有两种，明显有B(n,S)=B(n-1,S-A(n))+B(n-1,S+A(n))
然后递归求解B(n,S),递归结束条件为当索引为0时,目标值刚好为0。即没做任何加减处理的初始条件。