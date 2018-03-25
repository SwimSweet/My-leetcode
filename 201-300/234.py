class Solution:
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        rev=None
        slow=fast=head
        while fast and fast.next:
            fast=fast.next.next
            temp=rev
            rev=slow
            slow=slow.next
            rev.next=temp
        if fast:
            slow=slow.next
        while rev and rev.val==slow.val:
            rev=rev.next
            slow=slow.next
        return not rev