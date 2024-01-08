package datastructures.linkedlist.challenges;

public class SwapNodesInPairs {

    Node head;

    class Node {
        int value;
        Node next;
        public Node(int value){

            this.value = value;
        }
    }

    public Node swapPairs() {

        if(head == null)
            return head;

        Node slow = head;
        Node fast = head;
        Node temp = null;

        while(slow.next != null && fast != null){
            if(slow != head)
                slow = slow.next;
            fast = slow.next;
            if(fast == null) break;

            slow.next = fast.next;
            fast.next = slow;

            if(slow == head){
                head = fast;
            } else{
                temp.next = fast;
            }
            temp = slow;
        }

        return head;
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

    public static void main(String[] args) {

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        swapNodesInPairs.append(1);
        swapNodesInPairs.append(2);
        swapNodesInPairs.append(3);
        //swapNodesInPairs.append(4);

        swapNodesInPairs.swapPairs();
        swapNodesInPairs.print();
    }

}
