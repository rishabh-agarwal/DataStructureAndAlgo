package leetcode.practice;

import java.util.HashMap;

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
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap=0;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node newNode){
        Node temp = head.next;
        newNode.prev = head;
        newNode.next = tail;
        head.next = newNode;
        temp.prev = newNode;

    }

    public void remove(Node removeNode){
        Node tail = removeNode.next;
        Node head = removeNode.prev;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            int value = node.value;

            map.remove(key);
            remove(node);
            add(node);

            map.put(key, head.next);

            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            map.remove(key);
            remove(node);
        }
        if(map.size()==cap){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        add(new Node(key, value));
        map.put(key, head.next);
    }
}
