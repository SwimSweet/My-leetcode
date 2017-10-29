-------My-------------------------------------------
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s!=null)
        {
            if(equal(s,t))
            {
                return true;
            }
        return isSubtree(s.left,t)||isSubtree(s.right,t);
        }
        return  false;
    }
    public boolean equal(TreeNode root1,TreeNode root2)
    {
        if(root1==null && root2==null)
        {
            return true;
        }
        else if(root1!=null &&root2!=null)
        {
            if(root1.val!=root2.val)
            {
                return false;
            }
            else
            {
                return equal(root1.left,root2.left)&&equal(root1.right,root2.right);
            }
        }
        else{
            return false;
        }
    }
-----Explanation
题目为判断所给树是否为另一树的字树。解法比较暴力，就是先写一个函数，判断当前结点代表的字树是否和所给树相等。
然后先序遍历整棵二叉树，判断是否其中某个结点代表的字树和所给树相等。