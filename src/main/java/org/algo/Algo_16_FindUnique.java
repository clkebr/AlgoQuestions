package org.algo;
    /*There is an array with some numbers. All numbers are equal except for one. Try to find it!

    Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
    Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
    It’s guaranteed that array contains at least 3 numbers.

    The tests contain some very huge arrays, so think about performance.*/

import java.util.HashMap;
import java.util.Map;

public class Algo_16_FindUnique {
    public static void main(String[] args) {

        System.out.println("findUniq() = " + findUniq(new double[]{1, 1, 1, 2, 1, 1}));
    }

    public static double findUniq(double[] arr) {
        Map<Double,Integer> map = new HashMap<>();
        double uniq =0;
        for (double d : arr) {
            if(map.containsKey(d)) map.put(d,map.get(d)+1);
            else map.put(d,1);
        }
        for (Map.Entry<Double,Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) {
                 uniq= entry.getKey();
            }
        }
        return uniq;
    }
}
