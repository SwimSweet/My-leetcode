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