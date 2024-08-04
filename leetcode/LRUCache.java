package leetcode;

import java.util.*;

class LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }


    // head -> headNext -> node2 -> tail, add node0
    // head -> node0 -> headNext-> node2 -> tail
    private void addNode(Node newNode){
        Node headNext= head.next;

        newNode.prev = head;
        newNode.next = headNext;

        headNext.prev = newNode;
        head.next = newNode;
     }

    // head -> newnode1 -> newNode2 -> tail
    private void deleteNode(Node newNode){
        Node tail = newNode.next;
        Node head = newNode.prev;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (m.containsKey(key)){
            Node resNode = m.get(key);
            int ans = resNode.value;

            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            m.put(key, head.next);

            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }

        if(m.size() == cap){
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        m.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */