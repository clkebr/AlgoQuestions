package org.algo;

/*Write a function that takes in a non-empty array of integers and returns an array of
the same length, where each element in the output array is equal to the product of
every other number in the input array. In other words, the value at output[i] is equal to the
product of every number in the input array other than input[i] . Note that you're
expected to solve this problem without using division.
    Sample Input : [5, 1, 4, 2]
    Sample Output : [8, 40, 10, 20]
      8 is equal to 1 x 4 x 2
      40 is equal to 5 x 4 x 2
      10 is equal to 5 x 1 x 2
      20 is equal to 5 x 1 x 4*/


import java.util.Arrays;

public class Algo_17_ProductOfArray {

    public static void main(String[] args) {
         int[] arr = {5,1,4,2};
        System.out.println("getProductsOfArray " + Arrays.toString(getProductsOfArray(arr)));


    }

    public static int[] getProductsOfArray_BruteForce(int[] arr){   //O(n^2)
        int num=1;
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i!=j) {
                    num*=arr[j];
                }
            }
            result[i]= num;
            num=1;
        }
        return result;

    }

    public static int[] getProductsOfArray(int[] arr){   //O(n)
        int[] result = new int[arr.length];
        int leftRunning = 1;
        int rightRunning = 1;

        for (int i = 0; i < arr.length; i++) {
            result[i] = leftRunning;
            leftRunning *= arr[i];
        }
        for (int i = arr.length-1; i >= 0; i--) {
            result[i] *= rightRunning;
            rightRunning *= arr[i];
        }
        return result;
    }
}














