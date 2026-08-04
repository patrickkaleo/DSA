import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    // INSERTION
    public Node<T> insert(T data) {
        // create the new node from the data
        Node<T> node = new Node<>(data);
        this.root = this.insertRecursion(this.root, node);
        return node;
    }

    private Node<T> insertRecursion(Node<T> start, Node<T> node /* TO be inserted */) {
        if (start == null) {
            return node;
        }

        // determine weather to go right or left
        int comparison = start.getData().compareTo(node.getData());

        if (comparison > 0) {
            // the data of the new node is less than current, therefore we got left
            start.setLeft(insertRecursion(start.getLeft(), node));

        } else if (comparison < 0) {
            // otherwise got right
            start.setRight(insertRecursion(start.getRight(), node));
        } else
            return node; // duplicate are not allowed here
        return start;
    }

    // TRAVERSAL ALGORITHMS
    public String BFS() {
        // depth first search: look at the tree per level
        // put current in queue and explore every child, for that current
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.root);
        StringBuilder sb = new StringBuilder().append("[ Breadth First Search ]: ");

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            sb.append("\t").append(current.getData());
            if (current.getLeft() != null)
                queue.add(current.getLeft());
            if (current.getRight() != null)
                queue.add(current.getRight());
        }

        sb.append("\n\n");
        return sb.toString();
    }

    private void preorder(StringBuilder sb, Node<T> start) {
        // ROOT -> LEFT -> RIGHT
        if (start == null)
            return;
        sb.append("\t").append(start.getData()).append(" "); // start here corresponds to every node that will be
                                                             // encountered on the when we traverse the node at every
                                                             // level
        preorder(sb, start.getLeft()); // traverse the left path
        preorder(sb, start.getRight()); // go right as well
    }

    private void postorder(StringBuilder sb, Node<T> start) {
        // go as deep into the tree and then back track
        if (start == null)
            return;

        // LEFT -> RIGHT -> ROOT
        postorder(sb, start.getLeft()); // traverse the left path
        postorder(sb, start.getRight()); // go right as well
        sb.append("\t").append(start.getData()).append(" "); // start here corresponds to every node that will be
                                                             // encountered on the when we traverse the node at every
                                                             // level
    }

    private void inorder(StringBuilder sb, Node<T> start) {
        if (start == null)
            return;

        // LEFT -> ROOT -> RIGHT
        inorder(sb, start.getLeft()); // traverse the left path
        sb.append("\t").append(start.getData()).append(" "); // start here corresponds to every node that will be
                                                             // encountered on the when we traverse the node at every
                                                             // level
        inorder(sb, start.getRight()); // go right as well
    }

    public String DFSPreorder() {
        StringBuilder sb = new StringBuilder().append("Depth First Search [Preorder] => ");
        this.preorder(sb, root);
        sb.append("\n\n");
        return sb.toString();
    }

    public String DFSPostorder() {
        StringBuilder sb = new StringBuilder().append("Depth FIrst Search [Postorder] => ");
        this.postorder(sb, root);
        sb.append("\n\n");
        return sb.toString();
    }

    public String DFSInorder() {
        StringBuilder sb = new StringBuilder().append("Depth FIrst Search [Inorder] => ");
        this.inorder(sb, root);
        sb.append("\n\n");
        return sb.toString();
    }

    // OTHER ALGORITHMS
    private int countNodes(Node<T> start) {
        // count the total number of nodes in the tree
        if (start == null)
            return 0;
        return 1 + countNodes(start.getLeft()) + countNodes(start.getRight());
    }

    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        return heightHelper(this.root, leftHeight, rightHeight);
    }

    private int heightHelper(Node<T> start, int leftHeight, int rightHeight) {
        if (start == null)
            return -1;
        leftHeight = heightHelper(start.getLeft(), leftHeight, rightHeight) + 1;
        rightHeight = heightHelper(start.getRight(), leftHeight, rightHeight) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    private int depthHelper(Node<T> start, Node<T> node) {
        if (node == null || start == null)
            return -1;
        T nodeData = node.getData();
        T startData = start.getData();
        if (nodeData.equals(startData))
            return 0;
        if (nodeData.compareTo(startData) < 0) {
            return 1 + depthHelper(start.getLeft(), node);
        } else
            return 1 + depthHelper(start.getRight(), node);
    }

    public int getDepth(Node<T> node) {
        return this.depthHelper(this.root, node);
    }

    private void stringify(StringBuilder sb, Node<T> start, int depth) {
        if (start == null)
            return;

        // 1. Create a visual indentation based on tree depth (4 spaces per level)
        StringBuilder sbIndent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sbIndent.append("    ");
        }
        String indent = sbIndent.toString();

        // 2. Append the current node's data safely
        sb.append(indent).append("└── [").append(start.getData()).append("]\n");

        // 3. Recurse down the branches, incrementing the depth level counter
        if (start.getLeft() != null) {
            sb.append(indent).append("  L: \n");
            stringify(sb, start.getLeft(), depth + 2);
        }
        if (start.getRight() != null) {
            sb.append(indent).append("  R: \n");
            stringify(sb, start.getRight(), depth + 2);
        }
    }

    @Override
    public String toString() {
        if (this.root == null)
            return "[ EMPTY TREE ]";
        StringBuilder sb = new StringBuilder();
        sb.append("\n============================= TREE ========================= \n NODES: ").append(this.countNodes(this.root)).append("\n\n\n");

        // Start recursion at depth level 0
        this.stringify(sb, this.root, 0);
        sb.append("\n\n\n");
        return sb.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }

    private Node<T> root;
}