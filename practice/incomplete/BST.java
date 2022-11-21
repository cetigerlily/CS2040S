public class BST {
    static public int counter;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int N = io.getInt();
        io.println(counter);
        Node root = new Node(io.getInt());

        for(int i = 1; i < N; i++) {
            int nextValue = io.getInt();
            insertNode(root, nextValue);
            io.println(counter);
        }
        io.flush();
        io.close();
    }

    public static Node insertNode(Node current, int value) {
        if(current == null) {
            return new Node(value);
        }

        if(value < current.getValue()) { // into left tree
            counter += 1;
            current.updateLeft(insertNode(current.getLeft(), value));
        } else if (value > current.getValue()) { // into right r
            counter += 1;
            current.updateRight(insertNode(current.getRight(), value));
        }

        return current;
    }
}

class Node {
    private int value;
    private Node right;
    private Node left;

    public Node(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public int getValue() {
        return this.value;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getLeft() {
        return this.left;
    }

    public void updateLeft(Node input) {
        this.left = input;
    }

    public void updateRight(Node input) {
        this.right = input;
    }
}
