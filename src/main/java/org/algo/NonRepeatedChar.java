package org.algo;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatedChar {
    /* Find the first non-repeated char in a string ex: "a green apple" should return g */

    public static void main(String[] args) {
        System.out.println("findChar(\"a green apple\") = " + findChar("a green apple"));

    }
    public static char findChar( String str){
        // create hashmap for char and its count
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        var chars=str.toCharArray();
        // O(n)
        for(Character ch: chars) {
            if (map.containsKey(ch)) {
                count=map.get(ch);
                map.put(ch, count+1);
            }else {// first time we see ch
                map.put(ch,1);
            }
        }
        // O(n)
        for(Character ch: chars){
            if (map.get(ch)==1) return ch;
        }
        // O(n) + O(n) = O(2n) => O(n)
        return Character.MIN_VALUE;
    }
}
