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

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        else if (list2 == null) return list1
        else if (list1.`val` > list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            return list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            return list2
        }
    }

    fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
        var resultListNode1: ListNode? = ListNode(-1)
        var resultListNode = resultListNode1
        var l1: ListNode? = list1
        var l2: ListNode? = list2
        while (l1 != null && l2 != null) {
           if (l1.`val` > l2.`val`) {
                resultListNode?.next = l2
                l2 = l2.next
            } else {
                resultListNode?.next = l1
                l1 = l1.next
            }
            resultListNode = resultListNode?.next
        }
        resultListNode?.next = l1 ?: l2
        return resultListNode1?.next
    }

//    将所有链表合并到一个升序链表中，返回合并后的链表。
//    先合并两个，再顺序合并或者分治合并
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val result: ListNode = ListNode(-1)
        var resultTem: ListNode? = result
        if (lists.size > 0) {
            var min = 0
            while (true) {
                for (i in lists.indices) {
                    if (lists[min] == null) {
                        min = i
                        continue
                    }
                    if (lists[i] != null && lists[i]!!.`val` <= lists[min]!!.`val`) {
                        min = i
                    }
                }
                if (lists[min] != null) {
                    resultTem?.next = lists[min]
                    lists[min] = lists[min]?.next
                    resultTem = resultTem?.next
                } else break
            }
        }
        return result.next
    }
}