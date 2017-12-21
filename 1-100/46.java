class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> list=new  ArrayList<>();
        List<Integer>templist=new ArrayList<>();
        process(list,nums,0);
        return list;
    }
    public void process(List<List<Integer>>list,int[]nums,int j)
    {
        if(j==nums.length)
        {
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i =0 ;i <nums.length;i++) temp.add(nums[i]);
            list.add(temp);
        }
        else{
            for(int i =j;i<nums.length;i++)
            {
                swap(nums,i,j);
                process(list,nums,j+1);
                swap(nums,i,j);
            }
        }
    }
    
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
Explanation:
假设数组的数字集合是s={a1,a2,a3,a4,a5...an}。全排列的记号为perm。设pn=s-an。这perm(s)=a1perm(p1)+......anperm(pn)。
所以在遍历过程中不断把数字交换到当前处理数组开头，并接着递归处理接下来部分。当位置到了数组的结尾，就把当前数组的排列加到
总的List里。核心是同过两两交换得到不同的排列。