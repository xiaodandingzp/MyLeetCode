package com.example.myleetcode.ui.theme.leedcode;

// 143. 重排链表


/**
 * Definition for singly-linked list.
 */


public class Test143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = revert(slow.next);
        slow.next = null;
        while (head != null && second != null) {
            ListNode nextHead = head.next;
            ListNode nextSecond = second.next;
            head.next = second;
            second.next = nextHead;
            head = nextHead;
            second = nextSecond;
        }
    }

    public ListNode revert(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = revert(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
