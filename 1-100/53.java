-----------My--------------------------
class Solution {
    public int maxSubArray(int[] nums) {
        int farAway_sum=nums[0];
        int cur_sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            cur_sum=Math.max(cur_sum+nums[i],nums[i]);
            farAway_sum=Math.max(farAway_sum,cur_sum);
        }
        return farAway_sum;
    }
}

Explanation:
题目是求最大子序列和，就是很著名的kadanes算法求解的问题，也是动态规划的典型题。
假设B(n)是以索引n结束的最大子序列和。则对B(n+1)，只有两种情况，一种是B(n)+A(n+1)，一种是以A(n+1)开头也是结尾，即A(n+1)。
则B(n+1)=Max(B(n)+A(n),A(n+1))。
则最后对长度为n数组中全局的最大序列和就是Max(B(0),B(1)....B(n-1))。
在程序中:
用cur_sum代表B(n)，记录当前以索引n为结尾的最大序列和。用farAway_sum记录遍历到n时目前得到的最大序列和，也就是
Max(B(0)....B(n))