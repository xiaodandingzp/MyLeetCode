package com.example.myleetcode.ui.theme.listnode;

public class ListNodeJava {



    public ListNodeCl revert(ListNodeCl head) {
        if (head == null || head.next == null) return head;
        ListNodeCl temp = revert(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }


    public ListNodeCl revertTwo(ListNodeCl head) {
        if (head == null || head.next == null) return head;
        ListNodeCl cur = head.next;
        ListNodeCl temp = revertTwo(cur.next);
        head.next = temp;
        cur.next = head;
        return cur;
    }

    public ListNodeCl mergerTwo(ListNodeCl first, ListNodeCl second) {
        if (first == null) return second;
        if (second == null) return first;
        ListNodeCl result = new ListNodeCl();
        ListNodeCl temp = result;
        while (first != null && second != null) {
            if (first.value >= second.value) {
                temp.next = second;
                second = second.next;
            } else {
                temp.next = first;
                first = first.next;
            }
            temp = temp.next;
        }
        if (first != null) temp.next = first;
        if (second != null) temp.next = second;
        return result.next;
    }

    public ListNodeCl mergerTwo2(ListNodeCl first, ListNodeCl second) {
        if (first == null) return second;
        if (second == null) return first;
        if (first.value > second.value) {
            second.next = mergerTwo2(first, second.next);
            return second;
        } else {
            first.next = mergerTwo2(first.next, second);
            return first;
        }
    }

    public ListNodeCl reverseKGroup(ListNodeCl head, int k) {
        if (head == null || k < 1) return head;
        return helpReverseKGroup(head, k);
    }

    private ListNodeCl helpReverseKGroup(ListNodeCl head, int k) {
        ListNodeCl temp = head;
        int count = k;
        while (temp != null && count > 0) {
            temp = temp.next;
            count--;
        }
        if (count > 1) return head;
        ListNodeCl tempPair = helpReverseKGroup(temp, k);
        ListNodeCl first = revertK(head, k);
        head.next = tempPair;
        return first;
    }

    private ListNodeCl revertK(ListNodeCl head, int k) {
        if (head == null || k == 1) return head;
        ListNodeCl temp = revertK(head.next, --k);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    private ListNodeCl mergeK(ListNodeCl[] lists) {
        ListNodeCl result = new ListNodeCl();
        ListNodeCl resultTem = result;
        if (lists.length > 0) {
            int small = 0;
            while (true) {
                for (int i = 0; i < lists.length; i++) {
                    if (lists[small] == null) {
                        small = i;
                        continue;
                    }
                    if (lists[i] != null && lists[small].value >= lists[i].value) small = i;
                }
                if (lists[small] != null) {
                    resultTem.next = lists[small];
                    resultTem = resultTem.next;
                    lists[small] = lists[small].next;
                } else break;
            }
        }
        return result.next;
    }



    class ListNodeCl {
        int value;
        ListNodeCl next = null;
    }
}
