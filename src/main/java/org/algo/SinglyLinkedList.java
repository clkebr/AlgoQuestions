package org.algo;

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
        Node pointer = tail;
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
            if(pointer.next==null) System.out.print(pointer.value + " => null");
            System.out.println(pointer.value+" => ");
            pointer = pointer.next;
        }
    }
    void deleteNode(int value) {
        Node prev = head;
        Node current = head;
        while (current != null){
            if(current.value==value){
                // if the value in head
                if(current==head){
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
}
