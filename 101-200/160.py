# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        p,q = headA,headB
        m,n = 0,0
        while p is not None:
            m += 1
            p = p.next
        while q is not None:
            n += 1
            q = q.next
        p,q = headA,headB
        k=0
        if m > n:
            while k<m-n:
                p = p.next
                k+=1
        elif n > m:
            while k<n-m:
                q = q.next
                k+=1
        while p != q:
            p = p.next
            q = q.next
        return p  

Explanation:
考虑到若两个链表有重叠部分，则从第一个重叠点后面应该全部相同，所以考虑两个链表的长度差，并找到第一个交叉点。