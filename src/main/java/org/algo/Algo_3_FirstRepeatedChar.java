package org.algo;

import java.util.HashSet;
import java.util.Set;

public class Algo_3_FirstRepeatedChar {
    /*return the first repeated char in a string for example "a green apple" the first repeated char is e */
    public static void main(String[] args) {
        System.out.println("firstRepeatedChar(\"a green apple\") = " + firstRepeatedChar("a green apple"));
    }

    public static char firstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <str.length(); i++) {
            if(set.contains(str.charAt(i))){
                return str.charAt(i);
            }else{
               set.add(str.charAt(i));
            }
        }
        return Character.MIN_VALUE;
    }
}
