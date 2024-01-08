package datastructures.binarsearchtree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(47);
        tree.insert(21);
        tree.insert(76);
        tree.insert(18);
        tree.insert(52);
        tree.insert(82);
        tree.insert(27);

        System.out.println("root "+tree.root.value);
        System.out.println("root "+tree.root.left.left.value);
        System.out.println("root "+tree.root.left.right.value);

        System.out.println(tree.contains(76));

        System.out.println("Recursive Contains :" +tree.rContains(18));
        System.out.println("Recursive Contains :" +tree.rContains(19));
    }
}
