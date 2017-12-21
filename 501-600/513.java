class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            root=queue.poll();
            if(root.right!=null){
                queue.add(root.right);
            }
            if(root.left!=null){
                queue.add(root.left);
            }
        }
        return root.val;
        
        
    }
}
Explanation:
从右往左层次遍历树，返回最后遍历的结点的值即为所求。