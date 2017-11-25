------------My-------------------------------------
import java.util.Hashtable;
import java.util.ArrayList;
class Solution {
    public int[] findErrorNums(int[] nums) {
        ArrayList<Integer> list1=new ArrayList<Integer>();
        int max =nums.length;
        int result[]=new int [2];
		Hashtable<Integer,Integer>  hjw=new Hashtable<Integer, Integer>();
		for(int i=0 ; i<nums.length;i++)
		{
			hjw.put(nums[i],hjw.getOrDefault(nums[i],0)+1);
			
		}
		for(int i=1;i<=max;i++)
		{
			if(hjw.getOrDefault(i,0)==0)
			{
				result[1]=i;
			}
			if(hjw.getOrDefault(i,0)==2)
			{
				result[0]=i;
			}
		}
        return result;
 
    }
}
Explanation:
解法很暴力，就是用HashTable记录每个数字出现的次数，最后取出每出现过和出现过两次的。太丑陋。。

--------------Other------------------------
public int[] findErrorNums(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int duplicate = 0, n = nums.length;
    long sum = (n * (n+1)) / 2;
    for(int i : nums) {
        if(set.contains(i)) duplicate = i;
        sum -= i;
        set.add(i);
    }
    return new int[] {duplicate, (int)sum + duplicate};
}

Explanation:
时间复杂度O(n)，并且一次遍历就得到结果。思路是先将1-n求和得到sum=1+2+....n。然后在遍历的时候，
将出现过两次的用duplicate记录，并且每次sum都减去当前遍历的数，最后遍历完成后sum=missnum(不出现)-duplicate(出现两次)
。即将sum+duplicate就得到missnum。