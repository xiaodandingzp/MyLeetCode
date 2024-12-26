package com.example.myleetcode.ui.theme.leedcode;

// 133. 克隆图


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class Test133 {

    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());

        visited.put(node, clone);
        for (Node neighbors : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbors));
        }
        return clone;
    }

    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Set<Node> clonedSet = new HashSet<>();
        HashMap<Node, Node> cloneMap = new HashMap<>();
        LinkedList<Node> temp = new LinkedList<>();
        temp.add(node);
        while (!temp.isEmpty()) {
            Node preNode = temp.removeFirst();
            Node cloneNode;
            if (cloneMap.containsKey(preNode)) {
                cloneNode = cloneMap.get(preNode);
            } else  {
                cloneNode = new Node(preNode.val);
                cloneMap.put(preNode, cloneNode);
            }
            List<Node> cloneNeiList = new ArrayList<>();
            for (int i = 0; i < preNode.neighbors.size(); i++) {
                Node preNer = preNode.neighbors.get(i);
                Node cloneNer;
                if (cloneMap.containsKey(preNer)) {
                    cloneNer = cloneMap.get(preNer);
                } else  {
                    cloneNer = new Node(preNer.val);
                    cloneMap.put(preNer, cloneNer);
                }
                cloneNeiList.add(cloneNer);
                if (!clonedSet.contains(preNer)) {
                    temp.addLast(preNer);
                }
            }
            cloneNode.neighbors = cloneNeiList;
            clonedSet.add(preNode);
        }
        return cloneMap.get(node);
    }

}
