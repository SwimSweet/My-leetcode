class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return issame(root.left,root.right);
    }
    
    public boolean is(TreeNode root1,TreeNode root2)
    {
        if(root1==null &&root2==null) return true;
        if(root1==null ||root2==null) return false;
        return (root1.val==root2.val)&&issame(root1.right,root2.left)&&issame(root1.left,root2.right);
    }
}

Explanation:
从根节点开始，同步遍历左右子树，并且判断左右子树的值是否相等。
若不等，返回false;
若相等，此时将左子树节点作为另一棵树的根节点root1,右子树节点作为另一棵树的根节点roo2。
调用
需要递归同步遍历roo1的右子树,roo2的左子树节点值是否相等。root1的左子树和root2的右子树的节点值是否相等。