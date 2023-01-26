package org.algo;

public class SinglyLinkedApp {

    public static void main(String[] args) {

        /*
        Task -1: Get Kth Item From the Last
        1. You don’t know the size of the singly linked list.
        2. Find the Kth item from last and print it in one pass.*/

        SinglyLinkedList list1=new SinglyLinkedList();
        for(int i=1;i<11;i++) list1.add(i);
        list1.print();
        System.out.println();
        System.out.println("Kth item from last is:  " +list1.getKthFromLast(1));

        /*Task -2: Remove Kth Item From the Last

        1. You don’t know the size of the singly linked list.
        2. Delete the Kth item from last in one pass.*/

        list1.removeKthFromLast(10);
        System.out.println("After removing the kth element");
        list1.print();

        /*
        Reversing the nodes of a singly linked lists in one pass.*/

        list1.reverse();
        System.out.println("After reverse");
        list1.print();

        /*
        Remove Duplicates from a sorted singly linked list in one pass.*/
        SinglyLinkedList list2 = new SinglyLinkedList();
        int[] arr = {1,1,1,3,3,4,4,6,7,7,9,9,9};
        for (int i = 0; i < arr.length-1; i++) {
            list2.add(arr[i]);
        }
        System.out.println("before remove");
        list2.print();
        list2.removeDuplicate();
        System.out.println("after remove duplicate");
        list2.print();

    }
}
