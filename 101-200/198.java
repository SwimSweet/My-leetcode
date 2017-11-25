---------------My------------------------------
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        if(nums.length==3) return Math.max(nums[0]+nums[2],nums[1]);
        int[]records=new int[nums.length];
        records[0]=nums[0];
        records[1]=nums[1];
        records[2]=nums[0]+nums[2];
        for(int i=3;i<nums.length;i++)
        {
            records[i]=Math.max(records[i-2]+nums[i],records[i-3]+nums[i]);
        }
        return Math.max(records[nums.length-1],records[nums.length-2]);
    }
}
Explanation:
这道题的解法是受最大连续子串的思路得到的,是一道动态规划的题。假设B(n)为以位置n结束的所有序列的最大金额数。
则有B(n)=Max(B(n-2)+A(n),B(n-3)+A(n))，B(n)必由B(n-2)或者B(n-3)加上A(n)得到，并且全局最大的
B(n)必然在n=nums.length-1或者n=nums.length-2得到。(反证法很容易证明)
但是程序写得不好，导致需要对0-3情况进行分类...

---------------------------Other-------------------------------------------
public static int rob(int[] nums) 
	{
		int ifRobbedPrevious = 0; 	// max monney can get if rob current house
	    int ifDidntRobPrevious = 0; // max money can get if not rob current house
	    
	    // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
	    for(int i=0; i < nums.length; i++) 
	    {
	    	// If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
	        int currRobbed = ifDidntRobPrevious + nums[i];
	        
	        // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
	        int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
	        
	        // Update values for the next round
	        ifDidntRobPrevious  = currNotRobbed;
	        ifRobbedPrevious = currRobbed;
	    }
	    
	    return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
	}
Explanation:
看了别人的答案，发现别人也是动态规划，但是不需要用数组记录每个每个位置的最优值。只需设置ifRobbedPrevious和
ifDidntRobPrevious两个全局变量记录当前位置之前偷与不偷时候的最优值。
在遍历的时候，分别计算当前位置偷与不偷的值，偷这个位置，值由currRobbed=相邻没有偷的最优值+当前位置值确定。
不偷，此时这个位置值由currNotRobbed=Math.max(ifDidntRobPrevious, ifRobbedPrevious)。
进入下轮遍历，若偷这个位置下轮就变成相邻位置偷的最优ifRobbedPrevious。不偷就变成ifDidntRobPrevious。
则有ifRobbedPrevious=currRobbed，ifDidntRobPrevious=currNotRobbed
