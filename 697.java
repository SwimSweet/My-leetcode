import java.util.Hashtable;
class Solution {
    public int findShortestSubArray(int[] nums) {
        Hashtable<Integer,Integer> start=new Hashtable<Integer, Integer>();
        Hashtable<Integer,Integer> end=new Hashtable<Integer, Integer>();
        Hashtable<Integer,Integer> count=new Hashtable<Integer, Integer>();
        int maxcount=0;
        for(int i=0;i<nums.length;i++)
        {
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            if(!start.containsKey(nums[i]))
            {
                start.put(nums[i],i);
            }
            end.put(nums[i],i);
            maxcount=Math.max(maxcount,count.get(nums[i]));
        }
        int min=Integer.MAX_VALUE;
        for(Integer key:count.keySet())
        {
            if(count.get(key)==maxcount)
            {
                min=Math.min(min,end.get(key)-start.get(key));
            }
        }
        return min+1;
    }
}
Explanation:
1.用start,end,count三个Hash结构分别记录每个数字出现的最初位置，最后位置，出现次数。
2.然后遍历数组，更新三个Hash，得到整体数组的度。
3.最后遍历一次Hashcount.key，得到等于度等于整体度的最小连续子数组的长度。
