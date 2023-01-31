package org.algo;

public class MergedTwoLInkedLIst {

     /* Given the heads of two sorted linked list list1 and list2. Merge the two list in a one sorted list.
     The list should be made by splicing together the nodes of the first two list. Return the head of the merged linked list.
      You should do it inplace*/

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(7);
        n1.next=n2;n2.next=n3;


        Node m1=new Node(3);
        Node m2=new Node(4);
        Node m3=new Node(5);
        m1.next=m2;m2.next=m3;

        System.out.println(mergeLinkedLists(n1, m1).value);
    }

    public static Node mergeLinkedLists(Node headOne, Node headTwo){
        Node current1=headOne;
        Node current2=headTwo;
        Node prev=null;
        while(current1!=null && current2!=null ){
            if(current1.value < current2.value ) {
                prev=current1;
                current1=current1.next;
            } else {
                if (prev!=null) prev.next=current2;
                prev=current2;
                current2=current2.next;
                prev.next=current1;
            }
        }
        if (current1==null) prev.next=current2;
        return headOne.value< headTwo.value ? headOne:headTwo;

    }
}
