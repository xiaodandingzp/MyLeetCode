package com.example.myleetcode.ui.theme.leedcode;

import java.util.HashMap;


class LRU {
    private int maxSize;
    private int curSize = 0;
    private DLinkList head;
    private DLinkList end;

    private HashMap<Integer, DLinkList> map;
    LRU(int maxSize) {
        this.maxSize = maxSize;
        head = new DLinkList(-1, -1);
        end = new DLinkList(-1, -1);
        head.next = end;
        end.pre = head;
        map = new HashMap<>();
    }

    public void add(int key, int value) {
        if (map.containsKey(key)) {
            DLinkList temp = map.get(key);
            temp.value = value;
            moveEnd(temp);
        } else {
            DLinkList temp = new DLinkList(key, value);
            curSize++;
            map.put(key, temp);
            addToEnd(temp);
            if (curSize > maxSize) {
                DLinkList removeNode = removeFromHead();
                map.remove(removeNode.key);
                curSize--;
            }
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkList temp = map.get(key);
            moveEnd(temp);
            return temp.value;
        }
        return -1;
    }

    private DLinkList removeFromHead() {
        DLinkList result = head.next;
        head.next = result.next;
        result.next.pre = head;
        return result;
    }

    private void addToEnd(DLinkList temp) {
        end.pre.next = temp;
        temp.pre = end.pre;
        temp.next = end;
    }

    private void moveEnd(DLinkList temp) {
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
        addToEnd(temp);
    }


    class DLinkList {
        int key;
        int value;
        DLinkList pre;
        DLinkList next;
        DLinkList(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
}
