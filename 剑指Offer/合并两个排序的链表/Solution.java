/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode new_list = new ListNode(0);
        ListNode cur = new_list;
        ListNode cur_1 = list1,cur_2 = list2;
        while(cur_1 != null && cur_2 != null){
            if(cur_1.val < cur_2.val){
                cur.next = cur_1;
                cur = cur.next;
                cur_1 = cur_1.next;
            }else{
                cur.next = cur_2;
                cur = cur.next;
                cur_2 = cur_2.next;
            }
        }
        
        while(cur_1 != null){
            cur.next = cur_1;
            cur_1 = cur_1.next;
            cur = cur.next;
        }
        
        while(cur_2 != null){
            cur.next = cur_2;
            cur_2 = cur_2.next;
            cur = cur.next;
        }
        
        return new_list.next;
        
    }
}