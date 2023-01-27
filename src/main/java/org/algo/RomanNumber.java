package org.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RomanNumber {

    public static void main(String[] args) {

       String str = "CCC";
        System.out.println("convertRomanToInt(str) = " + convertRomanToInt(str));
    }
    public static int convertRomanToInt(String str) {
        Map<Character, Integer> romanNum = new HashMap<>();
        romanNum.put('I', 1);
        romanNum.put('X', 10);
        romanNum.put('V', 5);
        romanNum.put('L', 50);
        romanNum.put('C', 100);
        romanNum.put('D', 500);
        romanNum.put('M', 1000);

        int sum = romanNum.get(str.charAt(str.length()-1));
        for (int i = str.length()-2; i >= 0 ; i--) {
            if (romanNum.get(str.charAt(i)) >= romanNum.get(str.charAt(i + 1))  ) {
                sum += romanNum.get(str.charAt(i));
            } else if (romanNum.get(str.charAt(i)) < romanNum.get(str.charAt(i + 1))) {
                sum -= romanNum.get(str.charAt(i));
            }

        }
        return sum;
    }
}
