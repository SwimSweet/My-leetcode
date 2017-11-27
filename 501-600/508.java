class Solution {
    int maxnum=Integer.MIN_VALUE;
    int maxrecord=Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> Sumrecord=new HashMap<Integer,Integer>();
        preorder(root,Sumrecord);
        ArrayList<Integer>find=new ArrayList<Integer>();
        for(int temp:Sumrecord.keySet())
        {
            if(Sumrecord.get(temp)==maxrecord)  find.add(temp);
        }
        int []result=new int[find.size()];
        for(int i=0;i<find.size();i++) result[i]=find.get(i);
        return result;
    }
    public int  preorder(TreeNode root, HashMap<Integer,Integer>record)
    {
        int numrecord=1;
        if(root==null) return 0;
        int sum=root.val+preorder(root.left,record)+preorder(root.right,record);
        maxnum=sum>maxnum?sum:maxnum;
        if(record.containsKey(sum)) 
        {   numrecord=record.getOrDefault(sum,0)+1;
            record.put(sum,numrecord);          
        }
        else record.put(sum,1);
        maxrecord=numrecord>maxrecord?numrecord:maxrecord;
        return sum;
    }
}
Explanation:
用一个HashMap结构记录每个子树和对应的出现次数，并用一个全局变量记录最大出现次数，方便最后处理HashMap。