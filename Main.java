import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== PART 1: Testing MyHashTable ===");
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(997);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String data = "Data-" + random.nextInt(1000);
            table.put(new MyTestingClass(id, data), new Student("Student-" + i));
        }

        table.printBucketSizes();


        System.out.println("\n=== PART 2: Testing BST ===");
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "Five");
        tree.put(2, "Two");
        tree.put(8, "Eight");
        tree.put(1, "One");
        tree.put(9, "Nine");

        System.out.println("Iterating through the BST (In-Order):");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        System.out.println("Total elements in BST: " + tree.size());
    }
}