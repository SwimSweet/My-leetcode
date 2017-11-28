class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null) return null;
        return bulid(nums,0,nums.length-1);
    }
    
    public TreeNode bulid(int[]nums,int start ,int end)
    {
        if(start>end) return null;
        int maxix=start;
        for(int i=start;i<=end;i++)
        {
            if(nums[i]>nums[maxix]) maxix=i;
        }
        TreeNode root=new TreeNode(nums[maxix]);
        root.left=bulid(nums,start,maxix-1);
        root.right=bulid(nums,maxix+1,end);
        return root;
    }
}
Explanation:
分治法，每次都找出一段位置的最大值并创建新结点连接到树上。