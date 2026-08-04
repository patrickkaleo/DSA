public class Node<T extends Comparable<T>> {
    // /constructor
    Node(T data) {
        this.data=data;
        this.left=null;
        this.right=null;
    }

    //Getters 
    public T getData() { return this.data; }
    public Node<T> getRight() { return this.right; }
    public Node<T> getLeft() { return this.left; }

    //Setters
    void setData(T data) { this.data=data; }
    public Node<T> setRight(Node<T> right) { this.right=right; return right;}
    public Node<T> setLeft(Node<T> left) { this.left=left; return left;}

    private Node<T> right, left;
    private T data;
    
}
