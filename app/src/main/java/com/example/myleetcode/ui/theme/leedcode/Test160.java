package com.example.myleetcode.ui.theme.leedcode;


//160. 相交链表
public class Test160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        ListNode headATemp = headA;
        ListNode headBTemp = headB;
        while (headATemp != null) {
            aLength++;
            headATemp = headATemp.next;
        }
        while (headBTemp != null) {
            aLength--;
            headBTemp = headBTemp.next;
        }
        headATemp = headA;
        headBTemp = headB;
        if (aLength > 0) {
            while (aLength > 0) {
                headATemp = headATemp.next;
                aLength--;
            }
        } else if (aLength < 0) {
            while (aLength < 0) {
                headBTemp = headBTemp.next;
                aLength++;
            }
        }
        while (headATemp != null && headBTemp != null) {
            if (headATemp == headBTemp) return headATemp;
            headATemp = headATemp.next;
            headBTemp = headBTemp.next;
        }
        return null;
    }

    private ListNode revertListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = revertListNode(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
