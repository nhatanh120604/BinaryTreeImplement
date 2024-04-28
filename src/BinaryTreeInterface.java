/**
 * BinaryTreeInterface
 */
public interface BinaryTreeInterface<T> {
    // insert a node
    public void insert(Node node);

    public void display();

    public boolean search(int data);

    public void remove(int data);
}