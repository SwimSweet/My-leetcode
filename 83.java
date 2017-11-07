---------------My---------------------
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode p=head;
        while(p.next!=null)
        {
          if(p.next.val==p.val)
          {
              p.next=p.next.next;
          }
          else{
              p=p.next;
          }
        }
        return head;  
    }
}
Explanation:
循环遍历链表，但是代码需要处理空链表，并且用p记录头结点
-----------Other-------------

class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}
}
Explanation:
巧妙利用了递归。若当前节点为空或者下一节点是空就返回当前节点。若当前节点的值等于下一节点的值便删除下一节点。