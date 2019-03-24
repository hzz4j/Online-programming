import java.util.Stack;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = head;
        while(current != null){
            stack.push(current);
            current = current.next;
        }
        ListNode new_head = new ListNode(0);
        current = new_head;
        while(!stack.empty()){
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        return new_head.next;
    }
}