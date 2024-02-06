package org.algo;

    /*Given an integer K and a queue of integers, write code to reverse the order of
    the first K elements of the queue. (Use Java Collections)
    -Input: Q = [10, 20, 30, 40, 50], K = 4
    -Output: Q = [40,30, 20, 10,50]*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Algo_12_ReverseFirstKthElementQueue {

    public static void main(String[] args) {

        Deque<Integer> queue=new ArrayDeque<>();
        for (int i = 1; i < 6; i++) {
            queue.add(i);
        }
        System.out.println("queue = " + queue);
        System.out.println(reverseFirstK(queue, 3));

    }

    public static Deque<Integer> reverseFirstK(Deque<Integer> queue , int k){

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push( queue.removeFirst() );    // stack 1-2-3
        }
        while (!stack.isEmpty()) {            // reversed 3-2-1
            queue.add(stack.pop());
        }
        for (int i = 0; i < queue.size()-k; i++) {    // 3-2-1-4-5
            queue.add(queue.removeFirst());
        }

        return queue;
    }
}
