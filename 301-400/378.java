----------------------------------My----------------------------
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low=matrix[0][0];
        int high=matrix[matrix.length-1][matrix.length-1]+1;
        while(low<high)
        {
            int count=0;
            int mid=low+(high-low)/2;
            for(int i=0;i<matrix.length;i++)
            {
                int j=matrix.length-1;
                while(j>=0&&matrix[i][j]>mid) j--;
                count+=j+1;
            }
            if(count<k) low=mid+1;
            else{
                high=mid;
            }
        }
        return low;
    }
}
Explanation:
利用二分查找来找到第k个最小元素。先取二维数组中最小和最大的值取平均mid，然后计算出数组中小于等于mid的元素个数，即count。
若count小于k。代表mid小于第k个最小元素。若count大于等于k，则mid大于等于第k个元素。不断循环这过程，直至mid收敛到第k个最小元素。