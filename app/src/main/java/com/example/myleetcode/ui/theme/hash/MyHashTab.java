package com.example.myleetcode.ui.theme.hash;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 先用最粗暴的方式解决，在想办法优化
 * 如果有多个因素考虑，可以先考虑其中一个因素，在考虑其他的
 *
 *
 *
 * 哈希表的插入，查找，删除操作的时间复杂度都是O(1)
 *
 * 为什么用hashTab不能满足条件？因为hashTab中可能有的位置并没有元素，最不到等概率随机返回集合中的元素。
 *
 * HashMap是数组加链表的形式
 *
 * HashMap和HashTab的区别
 * HashMap初始容量是16 扩容是翻倍  hashtab初始容量是11 扩容是翻倍加1
 * 2、HashMap线程不安全,HashTable线程安全
 * 3.包含的contains方法不同
 * HashMap是没有contains方法的，而包括containsValue和containsKey方法；hashtable则保留了contains方法，效果同containsValue,还包括containsValue和containsKey方法。
 * 4.是否允许null值
 * Hashmap是允许key和value为null值的，用containsValue和containsKey方法判断是否包含对应键值对；HashTable键值对都不能为空，否则包空指针异常。
 * 5、计算hash方式不同
 * 6、扩容方式不同
 *
 * Java8，HashMap中，当出现冲突时可以：
 * 1.如果冲突数量小于8，则是以链表方式解决冲突。
 * 2.而当冲突大于等于8时，就会将冲突的Entry转换为**红黑树进行存储。**
 * 3.而又当数量小于6时，则又转化为链表存储。
 */



//设计一个数据结构，使插入、删除、随机返回数据集合中的一个值，要求把数据中每个数字被返回的概率是相同的 操作的复杂度都为O（1）
public class MyHashTab {

    private HashMap<Integer, Integer> localHashMap = new HashMap<>();
    private ArrayList<Integer> nums = new ArrayList<>();

    void addElement(int value) {
        if (localHashMap.containsKey(value)) return;
        localHashMap.put(value, nums.size());
        nums.add(value);
    }

    void remove(int value) {
        if (!localHashMap.containsKey(value)) return;
        int local = localHashMap.get(value);
        localHashMap.put(nums.get(nums.size() - 1), local);
        localHashMap.remove(local);
        nums.set(local, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);
    }

    int getRandom() {
        Random random = new Random();
        int local = random.nextInt(nums.size());
        return nums.get(local);
    }

    public List<List<String>> groupAnagrams(String [] strs) {
        Map<String, List<String>> map = new HashMap<> ();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = chars.toString();
            map.putIfAbsent(sortedString, new LinkedList<>());
            map.get(sortedString).add(str);
        }
        return new LinkedList<>(map.values());
    }
}

class LRUArr {
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode pre;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, ListNode> hashMap;
    ListNode top;
    ListNode tail;

    public LRUArr() {
        hashMap = new HashMap<>();
        top = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        top.next = tail;
        tail.pre = top;
    }

    int get(int key) {
        if (hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            if (node != null) {
                moveFirst(node);
                return node.value;
            }
            return -1;
        }
        return -1;
    }

    void moveFirst(ListNode node) {
        ListNode preTem = node.pre;
        if (preTem != null) {
            preTem.next = node.next;
        }
        node.next = top.next;
        top.next.pre = node;
        top.next = node;
        node.pre = top;
    }

    void put(int key, int value) {
        ListNode node;
        if (hashMap.containsKey(key)) {
            node = hashMap.get(key);
            node.value = value;
        } else {
            node = new ListNode(key, value);
        }
        moveFirst(node);
    }

    int getR() {
        return top.next.value;
    }

}