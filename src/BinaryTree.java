
public class BinaryTree implements BinaryTreeInterface {
    Node root;

    Node test;

    public void noThing() {
        System.out.println("noThing");
    }

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        if (root == null) {
            root = node;
            return root;
        } else if (data > root.data) {
            root.right = insertHelper(root.right, node);
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
            ;
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        } else if (node.data >= data) {
            searchHelper(root.left, data);
        } else if (node.data <= data) {
            searchHelper(root.right, data);
        }
        return false;
    }

    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        } else {
            System.out.println(data + " could not be found");
        }

    };

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        } else if (root.data >= data) {
            root.left = removeHelper(root.left, data);
        } else if (root.data <= data) {
            root.right = removeHelper(root.right, data);
        } else {// nod found
            if (root.left == null && root.right == null)// remove leaf node
            {
                root = null;
            } else if (root.right != null)// find a successor to replace this node
            {
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);

            } else {
                root.data = predecessor(root);
                root.right = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;

    }

    private void print_tree_1_(Node root, boolean is_left, int space_count, int dash_count) { // helper
        // function
        if (root != null) {
            for (int i = 0; i < space_count; i++)
                System.out.print("  ");
            for (int i = 0; i < dash_count - 1; i++)
                System.out.print("| ");
            if (dash_count > 0)
                System.out.print("|_");
            System.out.println(root.data);
            if (is_left) {
                print_tree_1_(root.left, true, space_count, dash_count + 1);
                print_tree_1_(root.right, false, space_count, dash_count + 1);
            } else {
                print_tree_1_(root.left, true, space_count + 1, dash_count);
                print_tree_1_(root.right, false, space_count + 1, dash_count);
            }
        }
    }

    public void print_tree_1() { // we are printing out the tree with the old-fashion Windows style
        // TODO:
        print_tree_1_(root, true, 0, 0);
    }

}
