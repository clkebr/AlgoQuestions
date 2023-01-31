package org.algo;

import java.util.ArrayList;
import java.util.List;

public class RecursiveFibonacci {

    public static void main(String[] args) {

        System.out.println(fib(6));
    }
    //1st way
    public static int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        else  return fib(n-1)+fib(n-2);

    }

}
