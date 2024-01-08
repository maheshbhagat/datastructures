package datastructures.linkedlist.challenges;

import datastructures.linkedlist.LinkedList;

public class RemoveAllDuplicateNodes {

    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList(6);
        linkedList.append(6);
        linkedList.append(6);
        linkedList.append(6);
        linkedList.append(6);
        linkedList.append(6);
        linkedList.append(6);

        linkedList.removeDuplicateNodes(6);

        linkedList.printList();

        System.out.println("-------------");

        LinkedList linkedListSeq = new LinkedList(1);
        linkedListSeq.append(2);
        linkedListSeq.append(6);
        linkedListSeq.append(3);
        linkedListSeq.append(4);
        linkedListSeq.append(5);
        linkedListSeq.append(6);

        linkedListSeq.removeDuplicateNodes(6);

        linkedListSeq.printList();

        System.out.println("-------------");

        LinkedList linkedListNull = new LinkedList(1);
        linkedListNull.removeFirst();

        linkedListNull.removeDuplicateNodes(6);

        linkedListNull.printList();


    }
}
