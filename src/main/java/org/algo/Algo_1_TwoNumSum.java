package org.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Algo_1_TwoNumSum {
    /*
    Given an array of integers nums and an integer target, return indices of the two
    numbers such that they add up to target.
    • You may assume that each input would have exactly one solution, and you
    may not use the same element twice.
    • You can return the answer in any order.
    Example:
    Input: nums = [2, 7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

    public static void main(String[] args) {

        int[] array={7,21,73,9,11,2};
        System.out.println(Arrays.toString(twoSum1(array,9)));
        System.out.println("Optimal Solution .....");
        System.out.println(Arrays.toString(twoSum2(array,9)));
        System.out.println("Two Pointer Solution .....");
        System.out.println(Arrays.toString(twoSumTwoPointer(array,9)));

    }

    public static int[] twoSum1(int[] array, int target){
        for(int i=0;i<array.length-1;i++){  //n
            for(int j=i+1; j<array.length;j++) //n
                if((array[i]+array[j])==target) return new int[]{i,j};//c
        }
        return new int[]{};
    }
    // my Optimal Solution O(n)
    public static int[] twoSum2(int[] array, int target){
        //Create HashMap
        Map<Integer,Integer> map=new HashMap<>();

        //Iterate over the array.
        // If a potential match exists return that indices else put the array value and index to map
        for(int i=0;i< array.length;i++){
            int potentialMatch=target-array[i];
            if(map.containsKey(potentialMatch)) return new int[]{ map.get(potentialMatch),i };
            else map.put(array[i],i);
        }
        return new int[]{};
    }

    public static int[] twoSumTwoPointer(int[] array, int target) {
        //Sort the array. (This has a cost! O(nlogn))
        Arrays.sort(array);
        //Define two index pointers i and j (i from 0 to length. / j from length to 0)
        int i=0;
        int j=array.length-1;
        while (i < j) {
            int sum= array[i]+array[j];
            if(sum==target) return new int[]{i,j};
            else if (sum<target) i++;
            else j--;
        }
        return new int[] {};
    }
}
