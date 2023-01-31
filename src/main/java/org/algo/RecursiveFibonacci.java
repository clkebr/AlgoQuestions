package org.algo;

import java.util.ArrayList;
import java.util.List;

public class RecursiveFibonacci {

    public static void main(String[] args) {

        System.out.println(fib(3));
    }
    //1st way
    public static int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        else  return n*fib(n-1);

    }

}
