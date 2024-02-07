package org.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Write a method that takes in an array of integers and returns an array of length 2
    representing the largest range of integers contained in that array. The first number in the
    output array should be the first number in the range, while the second number should be
    the last number in the range. A range of numbers is defined as a set of numbers that
    come right after each other in the set of real integers. For instance, the output array [2, 6]
    represents the range {2, 3, 4, 5, 6}, which is a range of length 5. Note that numbers don't
    need to be sorted or adjacent in the input array in order to form a range. You can assume
    that there will only be one largest range.

    Sample Input
    array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]

    Sample Output
    [0, 7]
    */
public class Algo_13_LongestRangeOfNums {
    public static void main(String[] args) {
        int[] array={1,-1,3,0,15,5,2,4,10,7,8,12,6};
        System.out.println(Arrays.toString(longestRange(array)));
    }
    public static int[] longestRange(int[]  array){
        int[] bestRange=new int[2];
        int longest=0;
        Map<Integer,Boolean> numsVisited=new HashMap<>();
        for(int num:array) {
            numsVisited.put(num,false); // O(n) x O(1)=O(n)
        }
        for (int num:array){ // O(n)
            if(numsVisited.get(num)) continue;
            numsVisited.put(num,true);
            int currentLength=1;
            int left=num-1;
            int right=num+1;
            while(numsVisited.containsKey(left)){
                numsVisited.put(left,true);
                left--;
                currentLength++;
            }
            while(numsVisited.containsKey(right)){
                numsVisited.put(right,true);
                right++;
                currentLength++;
            }
            if(currentLength>longest) {
                longest=currentLength;
                bestRange=new int[]{left+1,right-1};
            }
        }
        return bestRange;
    }

}
