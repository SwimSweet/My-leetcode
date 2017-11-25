---------自己开始想枚举1-n所有情况，然后用排列组合得到每种情况的数量再相加，后来觉得这种解法太low,
看了答案后，觉得想事情有时候应该从结果开始想，就拿这套题来说。从结果n来说，可以分解为从n-1走一步或者n-2就到了。
设B(n)代表给出的数字为n。当n>=3。有B(n)=B(n-1)+B(n-2)-------------------------------
class Solution {
    public int climbStairs(int n) {
        if(n<=0) return 0;
        if(n==1 ) return 1;
        if(n==2)   return 2;
        int one_step_before=2;
        int two_step_before=1;
        int total_count=0;
        for(int i=2;i<n;i++)
        {
            total_count=one_step_before+two_step_before;
            two_step_before=one_step_before;
            one_step_before=total_count;
        }
        return total_count;
      }
}