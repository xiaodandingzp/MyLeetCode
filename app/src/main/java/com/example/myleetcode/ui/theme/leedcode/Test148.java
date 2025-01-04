package com.example.myleetcode.ui.theme.leedcode;


// 148 排序链表-归并排序
public class Test148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = slow;
        while (fast != null) {
            temp = slow;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else break;
        }
        temp.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        ListNode result = new ListNode(-1);
        temp = result;
        while (first != null && second != null) {
            if (first.val >= second.val) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        if (first != null) temp.next = first;
        if (second != null) temp.next = second;
        return result.next;
    }
}
