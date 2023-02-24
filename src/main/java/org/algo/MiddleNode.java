package org.algo;

public class MiddleNode {
    /*• Given a non-empty, singly linked list with head node head, write a method to print a middle
    node of the linked list in one pass. If there are even nodes, then there would be two middle
    nodes, we need to print the second middle element.
    • Sample Input:
    11->2->13->44->5
    • Sample Output 13
    */

    public static void main(String[] args) {
        SinglyLinkedList sll=new SinglyLinkedList();
        for (int i = 1; i < 10; i++) {
            sll.add(i);
        }
        sll.print();
        System.out.println();
        printMiddle(sll);
    }
    public static void printMiddle(SinglyLinkedList sll){
        if(sll.isEmpty()) throw new IllegalArgumentException();
        var sJump=sll.head;
        var dJump=sll.head;
        while(dJump!=sll.tail && dJump.next!=sll.tail){
            sJump=sJump.next;
            dJump=dJump.next.next;
        }
        if(dJump== sll.tail) System.out.println(sJump.value);
        else System.out.println(sJump.value + "," + sJump.next.value);
    }
}
