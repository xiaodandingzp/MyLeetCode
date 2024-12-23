package com.example.myleetcode.ui.theme.leedcode;



 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


// 142. 环形链表 II
public class Test142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) return null;
        ListNode result = new ListNode(-1);
        result.next = head;
        while (result != slow) {
            result = result.next;
            slow = slow.next;
        }
        return result;
    }
}
