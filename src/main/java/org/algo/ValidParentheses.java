package org.algo;

public class ValidParentheses {

    /*Write a function that takes a string of parentheses, and determines if the order of the parentheses is
    valid. The function should return true if the string is valid, and false if it's invalid.
    */
    public static void main(String[] args) {

        System.out.println(isValid(""));
        System.out.println(isValid("(()))()"));
        System.out.println(isValid("("));
        System.out.println(isValid("((()))()()"));
        System.out.println(isValid("((()))())("));

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

}
