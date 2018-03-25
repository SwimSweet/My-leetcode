class Solution:
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        while head and head.val==val:
            head=head.next
        if head==None:
            return None
        pre=head
        now=pre.next
        while now:
            if now.val==val:
                pre.next=pre.next.next
                now=pre.next
            else:
                pre=pre.next
                now=now.next
        return head
		