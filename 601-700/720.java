class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String record="";
        HashSet<String> set=new HashSet<String>();
        for(String s:words)
        {
            if(s.length()==1||set.contains(s.substring(0,s.length()-1)))
            {
                record=(s.length()>record.length())?s:record;
                set.add(s);
            }
        }
        return record;
    }
}
Explanation:
利用Arrays类对原来的数组进行排序，排序后数组内元素先按长度由小到大排序，长度相等按字母顺序排序
利用HashSet记录之前出现过的单词，在遍历的时候只需要确定当前元素的前缀是否在HashSet中就可以确定是否可以由其他单词组成。

