package org.algo;

    /*Write a function that takes an integer as input, and returns the number of bits
    that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.
    Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case*/


public class Algo_14_BitCounting {

    public static void main(String[] args) {
        System.out.println("countBits() = " + countBits(1234));
    }

    public static int countBits(int n){
        int i=0;
        i += n%2;
        if (n > 1) {
            i += countBits(n / 2);
        }
        return i;
    }
}
