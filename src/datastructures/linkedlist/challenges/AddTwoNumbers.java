package datastructures.linkedlist.challenges;

public class AddTwoNumbers {

    Node head;

    class Node{

        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public boolean append(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            return true;
        }
        Node temp = head;
        while (temp != null){
            if(temp.next == null){
                temp.next = newNode;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private static Node reverse(Node newHead){

        Node temp = newHead;
        Node post = newHead;
        Node prev = null;

        while (temp!=null){
            post = temp.next;
            temp.next = prev;
            prev = temp;
            temp = post;
        }
        return prev;
    }

    public Node addTwoNumbers(Node l1, Node l2){

        l1 = reverse(l1);
        l2 = reverse(l2);

        Node sumNode = new Node(0);
        Node sumHead = sumNode;

        int temp = 0;
        int sum = 0;

        while(l2 != null && l1 != null) {

            sum = l1.value + l2.value;
            if (temp != 0) {
                sum = sum + temp;
                temp = 0;
            }

            Node elNode = null;
            if (sum >= 10) {
                elNode = new Node(sum % 10);
                temp = sum / 10;
            } else {
                elNode = new Node(sum);
            }

            sumNode.next = elNode;
            sumNode = elNode;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){

            sum = l1.value;
            if(temp != 0){
                sum = sum + temp;
                temp = 0;
            }

            Node elNode = null;
            if (sum >= 10) {
                elNode = new Node(sum % 10);
                temp = sum / 10;
            } else {
                elNode = new Node(sum);
            }

            sumNode.next = elNode;
            sumNode = elNode;

            l1 = l1.next;

        }

        while (l2 != null){

            sum = l2.value;
            if(temp != 0){
                sum = sum + temp;
                temp = 0;
            }

            Node elNode = null;
            if (sum >= 10) {
                elNode = new Node(sum % 10);
                temp = sum / 10;
            } else {
                elNode = new Node(sum);
            }

            sumNode.next = elNode;
            sumNode = elNode;

            l2 = l2.next;

        }

        if(temp != 0){
            Node elNode = new Node(temp);
            sumNode.next = elNode;
            sumNode = elNode;
        }

        return sumHead.next;
    }

    public static void print(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        AddTwoNumbers list1 = new AddTwoNumbers();
        list1.append(2);
        list1.append(4);
        list1.append(3);

        AddTwoNumbers list2 = new AddTwoNumbers();
        list2.append(5);
        list2.append(6);
        list2.append(4);

        Node sumList = list1.addTwoNumbers(list1.head, list2.head);
        print(sumList);
        //[8,9,9,9,0,0,0,1]
    }
}
