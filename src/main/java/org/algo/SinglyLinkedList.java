package org.algo;

import java.util.Deque;
import java.util.LinkedList;

public class SinglyLinkedList {

    Node head;
    Node tail;
    int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    boolean isEmpty(){
        return head == null;
    }
    // add data at the end of list
    void add(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            tail=head=newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    void print() {
        Node pointer = head;
        while (pointer!=null){
            if(pointer.next==null) System.out.println(pointer.value + " => null");
            else System.out.print(pointer.value+" => ");
            pointer = pointer.next;
        }
    }
    void deleteNode(int value) {
        Node prev = head;
        Node current = head;
        while (current != null){
            if(current.value == value){
                // if the value in head
                if(current == head){
                    head = current.next;
                    current.next = null; // will be available for garbage
                // if the value at the end
                }else if(current == tail){
                    tail= prev;
                    prev.next= null;
                }else{
                    prev.next = current.next;
                    current.next = null;
                }
                size--;
            }
            prev = current;
            current= current.next;
        }


    }
    int indexOf(int value){
        Node pointer = head;
        int index = 0;
        while (pointer != null){
            if(pointer.value == value){
                return index;
            }
            pointer = pointer.next;
            index++;
        }
        return -1;
    }
    public int getKthFromLast(int k){
        Node pointer1 = head;
        Node pointer2 = head;
        //take the pointer2 k times from head
        for (int i = 0; i < k-1; i++) {
            pointer2 = pointer2.next;

        }
        //position pointer2-pointer1 = k  keep it and move both until pointer comes tail
        //the value of pointer1 is the Kth from last
        while (pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

        }
        return pointer1.value;
    }
    public void removeKthFromLast(int k) {
        Node prevNode = null;
        Node pointer1 = head;
        Node pointer2 = head;
        //take the pointer2 k times from head
        for (int i = 0; i < k-1; i++) {
            pointer2 = pointer2.next;

        }
        //position pointer2-pointer1 = k  keep it and move both until pointer comes tail
        //the value of pointer1 is the Kth from last
        while (pointer2.next != null) {
            prevNode = pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

        }
        if(pointer1==head){
            head = pointer1.next;
            pointer1.next = null; // will be available for garbage
            // if the value at the end
        }else if(pointer1 == tail){
            tail= prevNode;
            prevNode.next= null;
        }else{
            prevNode.next = pointer1.next;
            pointer1.next = null;
        }
       size--;
    }
    public void reverse() {
        if (isEmpty()) return;
        Node previous = head;
        Node current = head.next;
        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        tail = head;
        tail.next = null;
        head = previous;
    }
    public void removeDuplicate(){   // O(n)
        Node current = head;
        while (current != null) {
            Node nextDistinctNode = current.next;
            while (nextDistinctNode != null && nextDistinctNode.value == current.value){
                nextDistinctNode = nextDistinctNode.next;
            }
            current.next = nextDistinctNode;
            current = nextDistinctNode;
        }
    }

    public boolean isPalindrome(){

        Node current=head;
        Deque<Integer> stack=new LinkedList<>();
        String s1="";
        String s2="";
        System.out.println("size = " + size);
        while(current!=null){
            s1+=current.value;
            stack.push(current.value);
            current=current.next;
        }
        for (int i = 0; i < this.size; i++) {
            s2+=stack.pop();
        }

        System.out.println("s2 = " + s2);
        System.out.println("s1 = " + s1);
        return s1.equals(s2);
    }

}
