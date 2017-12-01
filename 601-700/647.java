--------------------------My-------------------------
class Solution {
    public int countSubstrings(String s) {
        int palindromicCount=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=1;j+i<=s.length();j++)
            {
                palindromicCount+=judgePalindromic(s.substring(i,j+i));
            }
        }
        return palindromicCount;
    }
    
    public int judgePalindromic(String s)
    {
            if(s.equals(new StringBuffer(s).reverse().toString())) return 1;
            return 0;
    }
}
Explanation:
方法很暴力，把字符串的所有连续子串都判断一遍。