---------------------------My-----------------------
class Solution {
    int record=1;
    int num=0;
    public int kthSmallest(TreeNode root, int k) {
        Inorder(root,k);
        return num;
    }
    public void Inorder(TreeNode root,int k)
    {
        if(root==null) return ;
        Inorder(root.left,k);
        if(record==k) num=root.val;
        record++;
        Inorder(root.right,k);
    } 
}
Explanation:
找出二叉排序树的第K个最小值。利用二叉排序树的中序遍历是以树元素大小顺序遍历的性质。用一个全局变量记录遍历的结点数，
若是第K个遍历的结点就返回。