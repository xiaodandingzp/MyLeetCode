package com.example.myleetcode.ui.theme.M;


// 反转链表的部分节点
public class TestM {
    static public ListNode revert(ListNode head, int start, int end) {
        if (head == null) return head;
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        temp.next = head;
        int count = 0;
        while (temp.next != null) {
            ListNode cur = temp.next;
            if (count == start) {
                ListNode first = revertHelper(cur, end - start);
                temp.next = first;
                break;
            }
            count++;
            temp = cur;
        }
        return result.next;
    }

    private static ListNode revertHelper(ListNode head, int count) {
        ListNode first = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && count > 0) {
            count--;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        first.next = cur;
        return pre;
    }
}


