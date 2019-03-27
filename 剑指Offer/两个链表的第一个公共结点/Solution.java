/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//还有一种方法，不需要借助栈。先找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走，直到找到第一个公共结点。

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2==null)
            return null;
        
        int length_1 = 0,length_2 = 0;
        
        //calculate length
        ListNode current = pHead1;
        while(current != null){
            length_1++;
            current = current.next;
        }
        current = pHead2;
        while(current != null){
            length_2++;
            current = current.next;
        }
        
        
        if(length_1>length_2){
            int diff = length_1-length_2;
            while(diff != 0){
                diff--;
                pHead1 = pHead1.next;
            }
        }else{
            int diff = length_2-length_1;
            while(diff != 0){
                diff--;
                pHead2 = pHead2.next;
            }
        }
        
        while(pHead1 != null && pHead2 != null){
            if(pHead1 == pHead2)
                return pHead1;
            else{
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        
        return null;
          
    }
}