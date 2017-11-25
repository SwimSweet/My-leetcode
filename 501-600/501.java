--------------------------------------My------------------
import java.util.Hashtable;
class Solution {
    public int[] findMode(TreeNode root) {
        	Hashtable<Integer,Integer> Record=new Hashtable<>();
            int max=inorder(root,Record,0);
             List<Integer> list = new ArrayList<>();
            for(Integer temp:Record.keySet())
            {
                if(Record.get(temp)==max)
                {
                    list.add(temp);
                }
            }
          int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    public int  inorder(TreeNode root ,Hashtable<Integer,Integer> record ,int max)
    {
        if(root!=null)
        {
            record.put(root.val,record.getOrDefault(root.val,0)+1);
            max=(record.getOrDefault(root.val,0)>max)?(record.getOrDefault(root.val,0)):max;
            int left=inorder(root.left,record,max);
            int right=inorder(root.right,record,max);
            max=(max>left)?max:left;
            max=(max>right)?max:right;
            return max;
        }
        return max;
        
    }
    
}
Explanation:
设置一个全局变量HashSet和max.在递归遍历的时候不断更新，最后遍历HashSet，方法暴力简单。。

----------------------------------Other---------------------------------
class Solution {
    Integer prev=null;
    int max=0;
    int count=1;
    public int[] findMode(TreeNode root) {
         if (root == null) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
        
    }
    public void inorder(TreeNode root,List<Integer> list)
    {
             if(root==null) return;
            inorder(root.left,list);
            if(prev!=null){
                if(root.val==prev) 
                    count++;
                else{
                    count=1;
                }
            }
            if(count>max)
            {
                max=count;
                list.clear();
                list.add(root.val);
            }
            else if(count==max)
            {
                list.add(root.val);
            }
        prev=root.val;
        inorder(root.right,list);
      
    }
    
}
Explanation:
利用了BST中序遍历的顺序是个升序序列，所以等价于遍历一个升序数组。
在开始构思的时候就想过用三个整形变量记录最高次数，中序遍历中前一个数字，当前数字的记录数。一直在纠结如何在递归把这些
变量迭代更新。看了别人的答案发现别人用类成员声明。
在遍历的时候，若当前节点值和上一个相同。当前的记录数Count=Count+1。若Count>max。则更新max，并且此时当前节点数字的出现次数是目前为止最多，所以清空list。把当前的数字加到list里。
如果等于max。就加到list里。