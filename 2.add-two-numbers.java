/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.86%)
 * Total Accepted:    819.8K
 * Total Submissions: 2.7M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        Stack<ListNode> s1 = new Stack<ListNode>();

        ListNode c1 = l1,c2 = l2,c3 = head;
        int flag = 0;
        while(c1!=null && c2!=null){
            int tmp = c1.val+c2.val+flag;
            flag = tmp/10;
            tmp = tmp % 10;
            c3.next = new ListNode(tmp);

            c1 = c1.next;
            c2 = c2.next;
            c3 = c3.next;
        }

        while(c1 != null){
            int tmp = c1.val + flag;
            flag = tmp / 10;
            tmp = tmp % 10;
            
            c3.next = new ListNode(tmp);
            c1 = c1.next;
            c3 = c3.next;
        }

        while(c2 != null){
            int tmp = c2.val + flag;
            flag = tmp / 10;
            tmp = tmp % 10;
            
            c3.next = new ListNode(tmp);
            c2 = c2.next;
            c3 = c3.next;
        }

        if(flag != 0){
            c3.next = new ListNode(flag);
        }

        return head.next;
    }
}

