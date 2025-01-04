package com.example.myleetcode.ui.theme.leedcode;


// 147 对链表进行插入排序
public class Test147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode temp = head;
        while (temp != null) {
            ListNode node = temp;
            temp = temp.next;
            ListNode preSort = result;
            while (preSort.next != null && preSort.next.val < node.val) {
                preSort = preSort.next;
            }
            ListNode next = preSort.next;
            preSort.next = node;
            node.next = next;
        }
        return result.next;
    }
}
