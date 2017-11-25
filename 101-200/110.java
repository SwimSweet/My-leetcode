----------------------My---------------------------
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return (Math.abs(deep(root.left)-deep(root.right))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int deep(TreeNode root)
    {
        if(root==null) return 0;
        int left=deep(root.left);
        int right=deep(root.right);
        return 1+Math.max(left,right);
    }
}
Explanation:
解法很暴力，先准备一个求结点深度的函数。然后先序遍历二叉树，对每个结点都求出其左右子树深度，然后判断是否该结点是平衡。

----------------------------Other-------------------------------------------------------------
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return deep(root)!=-1;
    }
    public int deep(TreeNode root)
    {
        if(root==null) return 0;
        int left=deep(root.left);
        if(left==-1) return -1;
        int right=deep(root.right);
        if(right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
}
Explanation:
时间复杂度O(n)。deep函数若是返回正值就代表结点深度。根据结点的左右子树深度判断该结点是否平衡，若不平衡就直接返回-1代表不平衡。