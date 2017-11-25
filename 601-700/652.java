-------------------------Other----------------------------------------
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        process(root,list,new HashMap<String,Integer>());
        return list;
    }
    public String process(TreeNode root,List<TreeNode> record ,Map<String ,Integer> map)
    {
        if(root==null) return "->";
        String path=root.val+process(root.left,record,map)+process(root.right,record,map);
        if(map.getOrDefault(path,0)==1) record.add(root);
        map.put(path,map.getOrDefault(path,0)+1);
        return path;
    }
}
Explanation:
巧妙利用了Map数据结构，对树中所有的子树先序遍历形成的路径进行记录计数。若两个路径相同就代表是重复的子树。
看到Leetcode有人提问问到，因为无论先序，后序，中序遍历，单靠一个遍历是无法确定唯一树的，但是算法是利用路径
判断子树是否相同，别人更巧妙地用一个特殊记号"->"，换成其他也行，这时候就能确定唯一子树了。
例如先序遍历1,2,3,4。有很多种树形 。
1                          1
  2          和          2   3      等等
    3                          4
	  4

	  加上记号后变成
	  1                             1
   ->   2                        2     3
      ->  3                    -> -> ->  4
	    ->  4                          -> ->
		  -> ->
		  
这时候路径变成1,->,2,->,3->,4,->,-> 和1,2,->,->,3,->,4,->,-> 就能确定唯一子树了