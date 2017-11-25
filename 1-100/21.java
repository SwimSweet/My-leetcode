--------------------My-------------------------------
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head =new ListNode(1) ;
        head.next=null;
        ListNode p=head;
        while(l1!=null&l2!=null)
        {
            if(l1.val<l2.val) 
            {
                p.next=l1;
                l1=l1.next;
        }
            else{
                p.next=l2;
                l2=l2.next;
            }
		p=p.next;
		}
		p.next=(l1==null)?l2:l1;
        return head.next;
}
}
Explanation:
题目是合并两个不带头结点的链表。首先处理两个链表出现空的情况。
新建一个不带任何信息的头结点，方便后续输出和拼接，并申明一个结点类型p变量记录链表位置。
用while循环遍历l1,l2。根据大小关系依次添加到链表上。最后若其中一个链表遍历完成，将另一个链表拼接到p上就完成。
最后输出头结点的next。