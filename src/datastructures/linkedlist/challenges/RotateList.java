package datastructures.linkedlist.challenges;

public class RotateList {
    
    Node head;

    class Node {
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

    public void print(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }

    public Node rotateRight(int k) {

        if(head == null) return null;

        for (int i = 0; i < k; i++) {

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            if(fast == null){
                Node temp = head;
                slow.next = head;
                head = slow;
                temp.next = null;
            } else {

                fast.next = head;
                head = fast;

                if(slow.next == fast){
                    slow.next = null;
                } else {
                    slow.next.next = null;
                }
            }
        }

        return head;
    }

    public Node rotateRightV2(int k) {

        if(head == null) return null;

        for (int i = 0; i < k; i++) {

            Node lastOfTail = getLastOfTail(head);
            Node tail = lastOfTail.next;
            tail.next = head;
            head = tail;
            lastOfTail.next = null;
        }

        return head;
    }

    private Node getLastOfTail(Node head){

        Node temp = head;
        Node prev = null;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }

    public static void main(String[] args) {

        RotateList rotateList = new RotateList();
        rotateList.append(1);
        rotateList.append(2);
        rotateList.append(3);
        /*rotateList.append(4);
        rotateList.append(5);*/

        rotateList.rotateRightV2(2);
        rotateList.print();
        //System.out.println(rotateList.getLastNode(rotateList.head).value);

    }
}
