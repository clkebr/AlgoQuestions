package org.algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 extends LinkedHashMap<Integer,Integer> {

    public static void main(String[] args) {
        LRUCache2 lhm=new LRUCache2(3);
        lhm.put(1,1);
        lhm.put(2,2);
        lhm.put(3,3);
        System.out.println(lhm.get(1));
        lhm.put(4,4); // {cache= (4,4), (1,1) , (3,3)}
        lhm.entrySet().forEach(entry->{
            System.out.println("Key is: "+ entry.getKey() + " Value is:" + entry.getValue());
        });
        System.out.println();
    }
    private int capacity;
    public LRUCache2(int capacity){
        super(capacity, 0.75F, true);
        this.capacity=capacity;
    }
    public void put(int key,int value){
            super.put(key,value);
    }
    public int get(int key){return super.getOrDefault(key,-1);}

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size()>capacity;
    }

}
