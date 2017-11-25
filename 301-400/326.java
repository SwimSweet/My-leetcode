-----------My-----------
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0)
        {
            return false;
        }
        double c=Math.log10(n)/Math.log10(3);
        return (Math.ceil(c)==c);
    }
}
Explanation:
if n is a power of three, we have 3^m=n,so we have mlog10(3)=log10(n)->m=log10(n)/log10(3).
Then we just watch whether m is a integer or not .

----------Better-----------
public class Solution {
public boolean isPowerOfThree(int n) {
    // 1162261467 is 3^19,  3^20 is bigger than int  
    return ( n>0 &&  1162261467%n==0);
}
}
Explanation:
// 1162261467 is 3^19,  3^20 is bigger than int  
    return ( n>0 &&  1162261467%n==0);
First:
We get the max num that is a power of three within int
Then:
Let num%n:
case 0:true
case !0:false