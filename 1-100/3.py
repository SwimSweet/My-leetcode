class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0: return 0
        dict1 = {}
        dict2 = {}
        maxlength = 1
        templength = 1
        dict2[0] = s[0]
        dict1[s[0]] = 0
        for i in range(1, len(s)):
            if s[i] not in dict2[i - 1]:
                dict2[i] = dict2[i - 1] + s[i]
                dict1[s[i]]=i
                templength = len(dict2[i - 1]) + 1
            else:
                templength = i - dict1[s[i]]
                dict2[i] = s[dict1[s[i]] + 1:i + 1]
                dict1[s[i]] = i
            maxlength = max(maxlength, templength)
        return maxlength
Explanation：
动态规划。用两个hash-map结构记录以i为结尾的最大不重复字符串和每个字符最近出现的位置