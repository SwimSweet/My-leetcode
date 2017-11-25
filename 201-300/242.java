import java.util.*;
import java.lang.String;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        Hashtable<Character,Integer>Record=new Hashtable<Character, Integer>();
        for(char temp:s.toCharArray())
        {
            if(!Record.containsKey(temp))
            {
                Record.put(temp,1);
            }
            else{
                Record.put(temp,Record.get(temp)+1);
            }
        }
         for(char temp:t.toCharArray())
        {
            if(!Record.containsKey(temp))
            {
               return false;
            }
            else{
               if(Record.get(temp)==0)
               {
                   return false;
               }
                else{
                   Record.put(temp,Record.get(temp)-1);
               }
            }
        }
        return true;
    }
}
Explanation:
分别遍历两个字符串，并对其中字符进行计数，一增一减