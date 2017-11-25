class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int [][]pair=new int[nums.length][2];
	String []result=new String[nums.length];
	for(int i=0;i<nums.length;i++)
	{
		pair[i][0]=nums[i];
		pair[i][1]=i;
	}
	Arrays.sort(pair,(a,b)->(b[0]-a[0]));
	for(int i=0;i<nums.length;i++)
	{
		if(i==0)
		{
			result[pair[i][1]]="Gold Medal";

		}     else if (i == 1) {
			result[pair[i][1]] = "Silver Medal";
		}
		else if (i == 2) {
			result[pair[i][1]] = "Bronze Medal";
		}
		else {
			result[pair[i][1]] = (i + 1) + "";
		}
	}
    return result;
    }
}
Explanation:
显然题目和排序有关，并且最后输出的数组的元素值为初始元素逆序的排名。第一，二，三换对应字符串。
但是直接数组逆排序会打乱原来数组中元素的排列顺序，所以用一个二维数组记录原来数组的元素值和初始的索引号。即（元素值，索引号）
按照元素值排序后，数组会按元素值大小从大到小排列。
最后按照从大到小放到一个新的String 数组，解决。