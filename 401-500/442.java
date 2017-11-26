------------------------------My--------------------
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> record=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[(nums[i]<0?-1*nums[i]:nums[i])-1]<0) record.add(nums[i]<0?-1*nums[i]:nums[i]);
            else nums[(nums[i]<0?-1*nums[i]:nums[i])-1]*=-1;
        }
        return record;
    }
}
Explanation:
遍历数组，若第一次访问当前值对应的位置，便令该位置为负，若有重复值，下次再访问到相同位置便为负，负值就
可判断当前访问值为重复。
