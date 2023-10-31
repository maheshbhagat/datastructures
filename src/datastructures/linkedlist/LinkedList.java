package datastructures.linkedlist;

public class LinkedList {

    Node head;
    Node tail;
    int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public class Node{

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //append
    public void append(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }


    //remove last
    //prepend
    //remove first
    //get
    //set
    //insert
    //remove
    //reverse

    public void printList(){

        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getLength() {
        System.out.println("Length :: " + length);
    }

    public void getHead() {
        System.out.println("Head :: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail :: " + tail.value);
    }
}
