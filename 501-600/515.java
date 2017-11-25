class Solution {
    public List<Integer> largestValues(TreeNode root) {
        TreeMap<Integer,Integer> record=new TreeMap<Integer,Integer>();
        process(root,1,record);
        int size=record.keySet().size();
        List<Integer> list=new ArrayList<>();
        for(Integer deep:record.keySet())
        {
            list.add(record.get(deep));
        }
        return list;
        
    }
    public void process(TreeNode root,int deep,TreeMap<Integer,Integer> record)
    {
        if(root==null) return ;
        if(record.containsKey(deep)) record.put(deep,root.val>record.get(deep)?root.val:record.get(deep));
        else  record.put(deep,root.val);
        process(root.left,deep+1,record);
        process(root.right,deep+1,record);
    }
}
Explanation:
运用TreeMap数据结构在树的遍历的时候不断更新所在层次的最大值。
最后因为TreeMap对键默认排序，按顺序添加到list后返回。