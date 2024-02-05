package org.algo;
/*How do we check if the expressions are balanced with the opening and closing delimiters?
Example Valid Description
(A+B)+(C-D) Yes Symbols are balanced.
((A+B)+(C-D) No One Closing brace missing
((A+B)+[C-D]) Yes Symbols are balanced.
((A+B)+[C-D]} No The last closing brace does not match the first opening paranthesis*/

import java.util.Stack;

public class Algo_6_SymbolBalancing {

    public static void main(String[] args) {

        System.out.println("checkBalance() = " + checkBalance("((A+B)+[C-D]))"));

    }

    public static boolean checkBalance(String str) {
        Stack<Character> charStack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                charStack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (charStack.isEmpty()) {
                    return false;  // Unmatched closing delimiter
                }
                char poppedChar = charStack.pop();
                if (!isMatching(poppedChar, c)) {
                    return false;  // Mismatched opening and closing delimiters
                }
            }
        }
        // Check if there are unmatched opening delimiters
        return charStack.isEmpty();
    }

    private static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}
