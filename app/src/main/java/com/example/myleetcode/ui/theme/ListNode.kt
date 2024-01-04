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

    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return head
        val resultNode = ListNode(-1)
        var nodeTemp = resultNode
        var first = head
        var second = first.next
        while (first != null && second != null) {
            first.next = second.next
            nodeTemp.next = second
            second.next = first
            nodeTemp = first
            first = first.next
            if (first != null) {
                second = first.next
            } else second = null
        }
        if (first != null) nodeTemp.next = first
        return resultNode.next
    }

//    递归解决方法 两两交换链表中的节点（相当于三个节点，前两个节点互换位置，一直重复这个步骤）
    fun swapPairs1(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val next = head.next
        head.next = swapPairs1(next?.next)
        next!!.next = head
        return next
    }

//**********************************************************************************************
//   接下来是链表


//    链表翻转---递归
    fun fanzhuan(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val temp = fanzhuan(head.next)
        head.next?.next = head
        head.next = null
        return temp
    }


    //    链表翻转---非递归
    fun fanzhuan2(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }

    fun isPalindromeListNode(head: ListNode?): Boolean {
        if (head?.next == null) return true
        var fast = head.next
        var slow = head
        var second = head
        while (fast?.next?.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
        }
        if (fast!!.next != null) {
            second = slow?.next?.next
        }
        slow?.next = null
        return isEqual(head, fanzhuan2(second))
    }

    fun isEqual(list1: ListNode?, list2: ListNode?): Boolean {
        var node1 = list1
        var node2 = list2
        while (node1 != null && node2 != null) {
            if(node1.`val` != node2.`val`) return false
            node1 = node1.next
            node2 = node2.next
        }
        return node1 == null && node2 == null
    }


// 两两翻转链表---非递归
    fun fanzhuanTwo(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var pre = ListNode(-1)
        var result = head.next
        var cur = head
        while (cur?.next != null) {
            val next = cur.next
            cur.next = next?.next
            next?.next = cur
            pre.next = next
            pre = cur
            cur = cur.next
        }
        return result
    }

//    两两翻转链表---递归
    fun fanzhuanTwo2(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var pre = head
        var cur = head.next
        var temp = fanzhuanTwo2(cur!!.next)
        pre.next = temp
        cur.next = pre
        return cur
    }

//    合并两个有序列表-递归
    fun merginList(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        if (list1.`val` > list2.`val`) {
            list2.next = merginList(list1, list2.next)
            return list2
        }
        else {
            list1.next = merginList(list1.next, list2)
            return list1
        }
    }

//    K 个一组翻转链表---递归
    /**
     * 先写一个翻转k个节点的函数，返回头部和尾部
     *
     */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) return head
        if (k <= 0) return head
        var temp = head
        var size = 1
        while (temp != null && size < k) {
            size++
            temp = temp.next
        }
        if (size < k || temp == null) return head
        val next = reverseKGroup1(temp.next, k)
        val pair = reverseKGroupK(head, k)
        pair.second?.next = next
        return pair.first
    }

    fun reverseKGroupK(head: ListNode?, k: Int): Pair<ListNode?, ListNode?> {
        var pre = head
        var cur = head?.next
        var count = 1
        while (count < k) {
            count++
            val temp = cur?.next
            cur?.next = pre
            pre = cur
            cur = temp
        }
        return Pair(pre, head)
    }

    fun reverseKGroup1(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) return head
        var temp = head
        var length = 0
        while (temp != null) {
            length++
            temp = temp.next
        }
        var result = ListNode(-1)
        result.next = head
        var pre: ListNode? = result
        var cur = head
        for (i in 0 until (length / k)) {
            for (i in 1 until k) {
                val next = cur?.next
                cur!!.next = next?.next
                next!!.next = pre?.next
                pre!!.next = next
            }
            pre = cur
            cur = pre?.next
        }
        return result.next
    }

}