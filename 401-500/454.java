class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> ABSum=new HashMap<>();
        for (int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++)
            {
                ABSum.put(A[i]+B[j],ABSum.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        int count=0;
        for (int i=0;i<C.length;i++)
        {
            for (int j=0;j<D.length;j++)
            {
                count+=ABSum.getOrDefault(-C[i]-D[j],0);
            }
        }
        return count;
    }
}
Explanation:
刚开始尝试用4重循环，时间复杂度O(n^2)。结果不行。参考别人答案，首先用HashMap记录其中两个数组所有数字和的出现次数。
然后遍历剩下的两个数组，从HashMap中取出-(C[i]+D[j])的出现次数。
