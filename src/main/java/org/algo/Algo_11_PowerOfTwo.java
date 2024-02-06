package org.algo;
/*Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x*/
public class Algo_11_PowerOfTwo {
    public static void main(String[] args) {
        System.out.println("isPowerOfTwo() = " + isPowerOfTwo(8));
    }
    public static boolean isPowerOfTwo(int num){
        if(num <= 0) return false;
        if(num == 1) return true;
        if(num%2 == 0 ) return isPowerOfTwo(num/2 );
        else return false;
    }
}
