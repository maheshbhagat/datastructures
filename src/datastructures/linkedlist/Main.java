package datastructures.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.prepend(3);



        System.out.println("Removed Last :: "+ linkedList.removeLast().value);
        System.out.println("Removed First :: "+ linkedList.removeFirst().value);

        System.out.println("Get 2 :: "+ linkedList.get(2).value);
        System.out.println("Set 2 :: "+ linkedList.set(1, 6));

        System.out.println("Insert 0 :: "+ linkedList.insert(1, 5));
        System.out.println("Remove 2 :: "+ linkedList.remove(2));

        linkedList.printList();
        linkedList.getHead();
        linkedList.getTail();
        linkedList.getLength();
        
        linkedList.reverse();
        linkedList.printList();

    }
}
