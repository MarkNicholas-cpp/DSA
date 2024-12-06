package Trees;

public class BinaryTree {
    private int index = -1;

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null)
            return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.data);
    }

    // Method to print the tree with labels after data: "data : label"
    public void printTree(Node root) {
        printTreeHelper(root, "", true, "Root");
    }

    // Helper method for printTree with data : label format
    private void printTreeHelper(Node root, String indent, boolean isLeft, String position) {
        if (root == null) {
            return;
        }

        // Print the data followed by the label (data : label)
        String nodeLabel = position.equals("Root") ? "Root" : position.equals("Left") ? "Left" : "Right";
        System.out.println(indent + (isLeft ? "├── " : "└── ") + root.data + " : " + nodeLabel);

        // Recursively print left and right children
        printTreeHelper(root.left, indent + (isLeft ? "│   " : "    "), true, "Left");
        printTreeHelper(root.right, indent + (isLeft ? "│   " : "    "), false, "Right");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1});
        
        // Print tree with custom node labels after the data
        tree.printTree(root);
    }
}
