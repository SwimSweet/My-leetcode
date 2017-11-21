class Solution {
    public int arrangeCoins(int n) {
              return (int)Math.floor((Math.sqrt(1+8*(long)n)-1)/2);
        
    }
}
Explanation:
数学不等式求最靠近右根的整数。。