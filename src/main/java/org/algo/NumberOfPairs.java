package org.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfPairs {
    /*You are given array of integers, your task will be to count all pairs in that array and return their count.
    Notes:
    Array can be empty or contain only one value; in this case return 0
    If there are more pairs of a certain number, count each pair only once. E.g.: for [0, 0, 0, 0] the return
    value is 2 (= 2 pairs of 0s)
    Random tests: maximum array length is 1000, range of values in array is between 0 and 1000
        Examples
        [1, 2, 5, 6, 5, 2] --> 2
        ...because there are 2 pairs: 2 and 5
        [1, 2, 2, 20, 6, 20, 2, 6, 2] --> 4
        ...because there are 4 pairs: 2, 20, 6 and*/

    public static void main(String[] args) {

        System.out.println(findNumberOfPairs(new int[]{1, 2, 2, 20, 6, 20, 2, 6, 2}));
        System.out.println(findNumberOfPairs(new int[]{1, 2, 5, 6, 5, 2}));
        System.out.println(findNumberOfPairs(new int[]{1, 2, 5, 6, 5, 2, 3, 3}));
        System.out.println(findNumberOfPairs(new int[]{1}));
        System.out.println(findNumberOfPairs(new int[]{1,1,1}));
        System.out.println(findNumberOfPairs(new int[]{}));
    }
    public static int findNumberOfPairs(int[] arr){

        Set<Integer> set = new HashSet<>();
        int pair = 0;

        if(!(arr.length > 1)) return 0;
        else{
            for (int j : arr) {
               if(!set.add(j)){
                   pair++;
                   set.remove(j) ;
               }
            }
            return pair;
        }
    }

}
