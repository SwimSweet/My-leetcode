class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> Triangle=new ArrayList<>();
        List<Integer> last=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<i+1;j++)
            {
                if(j==0||j==i)
                {
                    temp.add(1);
                }
                else{temp.add(last.get(j-1)+last.get(j));}
            }
  
            last=temp;
            Triangle.add(temp);
        }
        return Triangle;
    }
}
