class Solution:
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        a = collections.Counter(nums)
        return sum(k>0 and i+k in a or k==0 and a[i]>1  for i in a)

		