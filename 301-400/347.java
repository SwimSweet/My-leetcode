import java.util.*;
import java.util.Map.Entry;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> record =new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(record.containsKey(nums[i]))
            {
                record.put(nums[i],record.get(nums[i])+1);
            }
            else{
                record.put(nums[i],1);
            }
        }
        ArrayList<Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(record.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
		public int compare(Entry<Integer, Integer> o1,
		                   Entry<Integer, Integer> o2) {
			return o2.getValue().compareTo(o1.getValue());
		}
	});
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            result.add(list.get(i).getKey());
        }
        return result;
        
    }
}
Explanation:
新建一个HashMap记录元素和出现次数，遍历数组得到<元素,次数>键值对，然后用Collections工具类对HashMap的value降序排序，然后取前K项。