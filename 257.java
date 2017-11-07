class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result=new ArrayList<String>();
        if(root!=null) addPath(root,"",result);
        return result;
    }
    public void addPath(TreeNode root,String path, List<String> result)
    {
        if(root.left==null &&root.right==null) result.add(path+root.val);
        if(root.left!=null) addPath(root.left,path+root.val+"->",result);
        if(root.right!=null) addPath(root.right,path+root.val+"->",result);
    }
}
Explanation:
刚开始想不出来，看了别人代码，真是巧妙。
设置一个作用于全局集合变量result，在调用函数的时候传入引用，函数修改的时候集合内容也相应修改。
然后设置一个路径参数，输入的是遍历到当前节点的路径，然后根据当前节点是否是叶子节点还是其他情况，对路径
做下一步修改。
若当前节点为叶子节点，则将路径加入集合result;
若当前节点有左，则将路径Path+root.val+"->"作为左孩子节点的输入路径。
右孩子节点同理。