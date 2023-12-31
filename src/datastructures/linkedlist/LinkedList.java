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

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //append
    public void append(int value) {
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //remove last
    public Node removeLast(){

        Node temp = head;
        Node pre = head;

        if(length == 0) return null;

        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    //prepend
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //remove first
    public Node removeFirst(){

        if(length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if(length == 0){
            tail = null;
        }

        return temp;
    }

    //get
    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    //set
    public boolean set(int index, int value){
        if(index < 0 || index >= length) return false;

        Node temp = get(index);
        temp.value = value;

        return true;
    }

    //insert
    public boolean insert(int index, int value) {

        if(index < 0 || index >= length) return false;

        if(index == 0){
            prepend(value);
            return true;
        } else if (index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length ++;
        return true;

    }

    //remove
    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if (index == 0) removeFirst();
        if (index == length-1) removeLast();

        Node pre = get(index-1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    //reverse
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node pre = null;
        Node post = temp.next;

        while (temp != null){
            post = temp.next;
            temp.next = pre;

            pre = temp;
            temp = post;
        }
    }

    //reverse for palindrome
    public Node reverse(Node middleNode){

        Node pre = null;
        Node temp = middleNode;
        Node post = middleNode;

        while (post != null){
            post = post.next;
            temp.next = pre;
            pre = temp;
            temp = post;
        }
        return pre;
    }

    public void printList(){
        System.out.println("Printing List :: ");

        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node findMiddleNode(){
        Node fast = head;
        Node slow = head;

        while(fast != null){
            if(fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }

        System.out.println("Middle of the Linked List :: "+ slow.value);
        return  slow;
    }

    public boolean hasLoop() {

        Node fast = head;
        Node slow = head;

        while(fast != null){

            if(fast.next != null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast){
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public Node removeDuplicateNodes(int value){

        if(head == null) return head;

        while(head != null && head.value == value){
            head = head.next;
            if(head == null){
                return null;
            }
        }

        Node temp = head;

        while(temp.next != null){
            if(temp.next.value == value){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public boolean isPalindrome(){

        Node firstHalfStart = head;
        Node middleNode = findMiddleNode();
        Node secondHalfStart = reverse(middleNode);

        while (secondHalfStart != null){
            if(firstHalfStart.value != secondHalfStart.value){
                System.out.println("Not palindrome");
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }

        System.out.println("Its palindrome");
        return true;
    }

    public void getLength() {
        System.out.println("Length :: " + length);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
