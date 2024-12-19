package com.example.myleetcode.ui.theme.leedcode;

import java.util.HashMap;
import java.util.Map;

// 138. 随机链表的复制
public class Test138 {
// Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node result = new Node(-1);
        Node temp = result;
        Node copy = head;
        while (copy != null) {
            Node nodeCur = new Node(copy.val);
            map.put(copy, nodeCur);
            temp.next = nodeCur;
            temp = temp.next;
            copy = copy.next;
        }
        for (Node node : map.keySet()) {
            Node ramPre = node.random;
            if (ramPre == null) map.get(node).random = null;
            else map.get(node).random = map.get(ramPre);
        }
        return result.next;
    }
}
