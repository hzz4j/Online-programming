
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null)
            return null;
        int length=0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            length++;
        }
        if(k>length)
            return null;
        
        int pos = length-k+1;
        int index=1;
        current = head;
        while(index != pos){
            current = current.next;
            index++;
        }
        return current;
    }
}