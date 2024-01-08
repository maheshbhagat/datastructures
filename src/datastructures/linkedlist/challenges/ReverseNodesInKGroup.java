package datastructures.linkedlist.challenges;

public class ReverseNodesInKGroup {

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

    private Node reverse(Node newHead){

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

    public Node kthNode(Node node, int k){

        k = k - 1;

        while( node != null && k > 0) {
            k--;
            node = node.next;
        }
        return node;
    }

    public Node reverseGroup(int k){
        Node temp = head;
        Node kthNode = null;
        Node newHead = null;
        Node prev = null;

        while (temp != null){

            kthNode = kthNode(temp, k);

            if(kthNode == null) {
                prev.next = temp;
                break;
            }

            newHead = kthNode.next;
            kthNode.next = null;
            Node reversed = reverse(temp);

            if(head == temp) {
                head = reversed;
            } else {
                prev.next = reversed;
            }

            prev = temp;
            temp = newHead;
        }
        return head;
    }

    public void print(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        reverseNodesInKGroup.append(1);
        reverseNodesInKGroup.append(2);
        reverseNodesInKGroup.append(3);
        reverseNodesInKGroup.append(4);
        reverseNodesInKGroup.append(5);
        reverseNodesInKGroup.append(6);
        reverseNodesInKGroup.append(7);

        System.out.println("Print before reversing : ");
        reverseNodesInKGroup.print();
        reverseNodesInKGroup.reverseGroup(3);
        System.out.println("Print after reversing : ");
        reverseNodesInKGroup.print();
    }
}
