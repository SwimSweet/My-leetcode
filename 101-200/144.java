----------------------------------------My------------------------------
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>preorder =new ArrayList<Integer>();
        preorder(preorder,root);
        return preorder;
        
    }
    public void preorder(List<Integer>process,TreeNode root)
    {
        if(root==null) return ;
        process.add(root.val);
        preorder(process,root.left);
        preorder(process,root.right);
    }
}
Explanation:
先序遍历二叉树。Leetcode竟然放在了Medium难度。蜜汁难度。
