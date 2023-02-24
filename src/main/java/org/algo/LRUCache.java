package org.algo;

import java.util.HashMap;

public class LRUCache {
    /*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
        Implement the LRUCache class:
        • LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
        •int get(int key) Return the value of the key if the key exists, otherwise return -1.
        • void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to
        the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
        •The functions get and put must each run in O(1) average time complexity.*/

    public static void main(String[] args) {
        LRUCache lru=new LRUCache(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.get(1));// Access , makes (1,1) most recently used
        lru.put(4, 4); // Cache ={ (4,4), (1,1), (3,3)}
        System.out.println(lru.get(2)); // return -1;
    }




        public class DNode{
            int key;
            int value;
            DNode prev;
            DNode next;

            public DNode() {
            }

            public DNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        HashMap<Integer, DNode> cacheMap=new HashMap<>();
        int size;
        int capacity;
        DNode head;
        DNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size=0;
            this.head=new DNode();
            this.tail=new DNode();
            head.next=tail;
            tail.prev=head;
        }
        public void addNode(DNode node){
            node.prev=head;
            node.next=head.next;

            head.next.prev=node;
            head.next=node;
        }

        public void removeNode(DNode node){
            DNode prev=node.prev;
            DNode next=node.next;

            prev.next=next;
            next.prev=prev;
        }

        public void moveToHead(DNode node){
            removeNode(node);
            addNode(node);
        }
        private DNode popTail(){
            DNode popped=tail.prev;
            removeNode(popped);
            return popped;
        }

        public int get(int key){
            DNode node= cacheMap.get(key);
            if (node==null) return -1;
            moveToHead(node);
            return node.value;
        }
        public void put(int key, int value){
            DNode node= cacheMap.get(key);
            if(node==null) {
                DNode newNode=new DNode(key, value);
                cacheMap.put(key, newNode);
                addNode(newNode);
                size++;
                if(size>capacity) {
                    DNode tail=popTail();
                    cacheMap.remove(tail.key);
                    size--;
                }
            }else {
                node.value = value;
                moveToHead(node);
            }
        }




}
