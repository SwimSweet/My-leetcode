------------判断所给的数是否为2的幂-----------
------------转化为log，再进行判断------------
-------------My----------------------------
class Solution {
    public boolean isPowerOfTwo(int n) {

        double c=Math.log10(n)/Math.log10(2);
        return (n>0&&Math.ceil(c)==c);
        
    }
}



----------Other----------------------------
----------因为若是2的幂，则其二进制表达必定有且仅有一个1，所以和其减一的数进行位与运算，判断是否为0----
class Solution {
    public boolean isPowerOfTwo(int n) {
         
        return (n>0&&(n&(n-1))==0);
    }
}