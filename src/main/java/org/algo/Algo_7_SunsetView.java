package org.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Algo_7_SunsetView {

    /*Given an array of buildings and a direction that all the buildings face, return an array of the indices of the buildings that can
    see the sunset. A building can see the sunset if it's strictly taller than all the buildings that come after it in the direction
    that it faces. The input array named buildings contains positive, non-zero integers representing the heights of the buildings. A
    building at index i thus has a height denoted by buildings[i] . All the buildings face the same direction, and this direction is
    either east or west, denoted by the input string named direction , which will always be equal to either "EAST" or "WEST" . In
    relation to the input array, you can interpret these directions as right for east and left for west. Important note: the indices in
    the output array should be sorted in ascending order.

    Sample Input buildings = [3, 5, 4, 4, 3, 1, 3, 2] direction = "EAST"
    Sample Output [1, 3, 6, 7] */

    public static void main(String[] args) {
        int[] buildings={3, 5, 4, 4, 3, 1, 3, 2};
        sunsetViews(buildings,"EAST").forEach(System.out::println);
    }
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        Stack<Integer> candidateBuildings = new Stack<>(); // O(n) space complexity
        int startIdx=0;
        int step=1;

        if( direction.equals("WEST") ){ startIdx= buildings.length-1; step=-1; }
        int idx=startIdx;
        while ( idx >= 0 && idx < buildings.length ){
            while( !candidateBuildings.isEmpty() && buildings[candidateBuildings.peek()] <= buildings[idx] ){
                candidateBuildings.pop();
            }
            candidateBuildings.push(idx);
            idx += step;
        }
        //O(n)
        if ( direction.equals("WEST" )) Collections.reverse(candidateBuildings); //O(n)
        return new ArrayList<>(candidateBuildings); // O(2n)= O(n) time complexity
    }
}
