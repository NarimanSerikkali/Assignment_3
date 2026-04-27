import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.BSTEntry> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public class BSTEntry {
        private K key;
        private V value;

        public BSTEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }

        Node curr = root;
        while (true) {
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) {
                if (curr.left == null) {
                    curr.left = new Node(key, val);
                    size++;
                    return;
                }
                curr = curr.left;
            } else if (cmp > 0) {
                if (curr.right == null) {
                    curr.right = new Node(key, val);
                    size++;
                    return;
                }
                curr = curr.right;
            } else {
                curr.val = val;
                return;
            }
        }
    }

    public V get(K key) {
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else return curr.val;
        }
        return null;
    }

    public void delete(K key) {
        Node parent = null;
        Node curr = root;

        while (curr != null && !curr.key.equals(key)) {
            parent = curr;
            if (key.compareTo(curr.key) < 0) curr = curr.left;
            else curr = curr.right;
        }

        if (curr == null) return;

        if (curr.left == null || curr.right == null) {
            Node newCurr;
            if (curr.left == null) newCurr = curr.right;
            else newCurr = curr.left;

            if (parent == null) root = newCurr;
            else if (curr == parent.left) parent.left = newCurr;
            else parent.right = newCurr;
            size--;
        } else {
            Node p = null;
            Node temp = curr.right;
            while (temp.left != null) {
                p = temp;
                temp = temp.left;
            }

            if (p != null) p.left = temp.right;
            else curr.right = temp.right;

            curr.key = temp.key;
            curr.val = temp.val;
            size--;
        }
    }

    @Override
    public Iterator<BSTEntry> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<BSTEntry> {
        private Stack<Node> stack = new Stack<>();
        private Node curr = root;

        @Override
        public boolean hasNext() {
            return curr != null || !stack.isEmpty();
        }

        @Override
        public BSTEntry next() {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (stack.isEmpty()) throw new NoSuchElementException();

            Node node = stack.pop();
            BSTEntry entry = new BSTEntry(node.key, node.val);
            curr = node.right;

            return entry;
        }
    }
}