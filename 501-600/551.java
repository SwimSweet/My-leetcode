class Solution {
    public boolean checkRecord(String s) {
        int late=0;
        int aaa=0;
        int record=0;
        boolean sss=true;
        for(char temp:s.toCharArray())
        {
            if(temp=='A')
            {
                aaa++;
            }
            if(temp=='L')
            {
                late++;
            }
            if(temp!='L')
            {
                late=0;
            }
            if(late>2)
            {
                sss=false;
            }
            
        }
        if(aaa>1||!sss)
        {
            return false;
        }
        return true;
    }
}