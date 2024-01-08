package datastructures.linkedlist.challenges;

import datastructures.linkedlist.LinkedList;

public class HasLoopLinkedList {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        // create a loop by connecting the tail to the second node
        linkedList.getTail().next = linkedList.getHead().next;

        System.out.println("Has Loop :: " + linkedList.hasLoop());


    }
}
