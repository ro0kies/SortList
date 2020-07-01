package SortList;

/**
 * @author wys
 * @date 2020/7/1 - 22:15
 * 归并
 */
public class mergeSort {

    public ListNode sort(ListNode head){

        ListNode mid=getMiddle(head);
        ListNode second=mid.next;
        mid.next=null;  //不影响second,但会影响head，相当于从中间分成两个链表
        ListNode left=sort(head);
        ListNode right=sort(second);

        return merge(left,right);

    }

    public ListNode getMiddle(ListNode x){
        if(x==null||x.next==null){
            return x;
        }
        ListNode quick=x;
        ListNode slow=x;

        while (quick.next.next!=null&&quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode head1=left,head2=right;
        ListNode head;
        if(left.val>right.val){
            head=head2;
            right=right.next;
        }else {
            head=head1;
            left=left.next;
        }

        ListNode cur=head;
        while(left!=null&&right!=null){
            if(left.val>right.val){
                cur.next=right;
                cur=cur.next;
                right=right.next;
            }else{
                cur.next=left;
                cur=cur.next;
                left=left.next;
            }

        }

        if(left==null){
            cur.next=right;
        }
        if(right==null){
            cur.next=left;
        }

        return  head;

    }
}


