package org.algo;

import java.util.Stack;

public class Algo_10_ValidParentheses {

    /*Write a function that takes a string of parentheses, and determines if the order of the parentheses is
    valid. The function should return true if the string is valid, and false if it's invalid.
    */
    public static void main(String[] args) {

        System.out.println(isValid(""));
        System.out.println(isValid2(""));
        System.out.println("------");
        System.out.println(isValid("(()))()"));
        System.out.println(isValid2("(()))()"));
        System.out.println("------");
        System.out.println(isValid("("));
        System.out.println(isValid2("("));
        System.out.println("------");
        System.out.println(isValid("((()))()()"));
        System.out.println(isValid2("((()))()()"));
        System.out.println("------");
        System.out.println(isValid("((()))())("));
        System.out.println(isValid2("((()))())("));
        System.out.println("------");

    }
    public static boolean isValid(String str){
        int sum=0;
        if(str.isEmpty()) return false;
        else{
            for (int i = 0; i < str.length(); i++) {
                if(sum<0) return false;
                if(str.charAt(i) == '(' ) sum++;
                else if(str.charAt(i) == ')') sum--;
            }
            return sum == 0;

        }
    }

    public static boolean isValid2(String str){
        Stack<Character> myStack = new Stack<>();
        if( str.length() == 0 ) return false;
        for ( char c : str.toCharArray() ) {
            if ( c == '(' ){
               myStack.push(c);
            }else if( c == ')' && myStack.isEmpty() ){
               return false;
            }else {
                myStack.pop();
            }
        }

        return myStack.isEmpty();
    }


}
