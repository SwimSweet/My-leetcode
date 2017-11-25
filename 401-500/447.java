Ps:英语差，看题目看了半天，原来题目说的i,j,k代表的是二维坐标点。。。
-------My-----------------	
--------判断是否相等-------
public static int count(int[] a,int[]b,int[]c)
	{
		if(dis(a,b)==dis(a,c))
		{
			return 1;
		}
		else{
			return 0;
		}
	}
----------求距离-----------	
public  static int  dis(int []a,int[]b)
	{
		int x=a[0]-b[0];
		int y=a[1]-b[1];
		return(x*x+y*y);
	}
	int count=0;
---------用了三层循环，遍历所有情况，但是时间复杂度太高，Leetcode不让过
for(int i=0;i<fuck.length;i++)
		{
			for (int j =0;j<fuck.length;j++)
			{
				for(int k=0;k<fuck.length;k++)
				{
					if(i==j||i==k||j==k)
						continue;
					else{
						count+=count(fuck[i],fuck[j],fuck[k]);
					}
				}
			}
		}
		

--------Other-----------------
看别人的答案，用了个绝妙的方法，就是在遍历坐标点时，用一个HashTable记录该点作为三元组<i,j,k>第一个时候，用距离将其他点进行分类。
对每组分类的点，其中的点和第一个点i距离都相等，所以从中选取两点（顺序有关），即排列中的选2.
import java.util.Hashtable;
class Solution {
    public int numberOfBoomerangs(int[][] points) {
	int count=0;

	Hashtable<Integer,Integer> record=new Hashtable<Integer,Integer>();
	for(int i=0;i<points.length;i++)
	{
		for(int j=0;j<points.length;j++)
		{
			if(i==j)
				continue;
			int temp=dis(points[i],points[j]);
			record.put(temp,record.getOrDefault(temp,0)+1);
		}
		for(int val:record.values())
		{
			count += val * (val-1);
		}
		record.clear();
	}
        return count;
    
}
    private int dis(int[] a, int[] b) {
	int dx = a[0] - b[0];
	int dy = a[1] - b[1];

	return dx*dx + dy*dy;
}
}
