
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return pathNodeSum(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public int pathNodeSum(TreeNode root ,int sum)
    {
        if(root==null) return 0;
        return (root.val==sum?1:0)+pathNodeSum(root.left,sum-root.val)+pathNodeSum(root.right,sum-root.val);
    }
}
Explnation:
创建一个函数，统计以当前遍历的结点为根符合要求的路径数量。最后递归遍树所有结点并相加。