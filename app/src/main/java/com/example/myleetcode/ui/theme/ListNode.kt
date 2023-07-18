package com.example.myleetcode.ui.theme


/***
 * 链表思路
 * 递归
 * 双指针
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null

//    19. 删除链表的倒数第 N 个结点
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head?.next == null) return null
        var fast = head
        var slow = head
        for (i in 0 until n) {
            if (fast == null) break
            fast = fast?.next
        }
        if (fast == null) return head.next
        while (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return head
    }

    fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
        if(head?.next == null) return null
        val num = trans(head, n)
        if (num == n) return head.next
        return head
    }

    private fun trans(head: ListNode?, n: Int): Int {
        if (head?.next == null) return 1
        val num = trans(head.next, n)
        if (num == n) {
            if (num == 1) head.next = null
            else head.next = head.next?.next
        }
        return num + 1
    }
}