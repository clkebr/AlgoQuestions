package org.algo;

import java.util.*;

public class Algo_4_FirstNonRepeatingChar {
    
    public static void main(String[] args) {

        String str="abbccddkK";
        System.out.println("firstNonRepeatedChar(str) = " + firstNonRepeatedChar(str));

    }
    public static char firstNonRepeatedChar(String str) {

        char firstNonRepeatedChar = 0;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character ch:str.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
              
            }
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) {
                firstNonRepeatedChar = entry.getKey();
                break;
            }

        }
        return firstNonRepeatedChar;
    }
}
