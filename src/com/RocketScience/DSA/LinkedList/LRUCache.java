package com.RocketScience.DSA.LinkedList;

import java.util.HashMap;

class DNode {
    int data;
    int key;
    DNode next;
    DNode prev;

    public DNode(int key, int data) {
        this.data = data;
        this.key = key;
    }
}


class LRU{
    private final HashMap<Integer, DNode> map;
    private final DNode head,tail;
    private final int capacity;
    private int count;

    public LRU(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new DNode(0,0);
        tail = new DNode(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(DNode DNode){
        DNode.prev.next = DNode.next;
        DNode.next.prev = DNode.prev;
    }

    public void addToHead(DNode DNode){
        DNode.next = head.next;
        DNode.prev = head;
        DNode.next.prev = DNode;
        head.next = DNode;
    }

    public int get(int key){
        if(map.containsKey(key)){
            DNode node = map.get(key);
            int result = node.data;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        System.out.println("Did not found any value with the key: "+key);
        return -1;
    }

    public void set(int key,int val){
        DNode node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.data = val;
            deleteNode(node);
        }else{
            node = new DNode(key, val);
            map.put(key, node);
            if(count < capacity){
                count++;
            }else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
        }
        addToHead(node);
    }
}

public class LRUCache {
    public static void main(String[] args) {
        LRU lru = new LRU(5);
        lru.set(1,5);
        lru.set(2,4);
        lru.set(3,3);
        lru.set(4,2);
        lru.set(5,1);
        System.out.println(lru.get(2));
    }
}
