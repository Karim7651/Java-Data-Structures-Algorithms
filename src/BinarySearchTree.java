import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinarySearchTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTreeNode insert(BinarySearchTreeNode currentNode, int value) {
        if (currentNode == null) {
            BinarySearchTreeNode newNode = new BinarySearchTreeNode(value);
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }

    void preOrder(BinarySearchTreeNode current) {
        if (current != null) {
            System.out.println(current.value);
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    void inOrder(BinarySearchTreeNode current) {
        if (current != null) {
            inOrder(current.left);
            System.out.println(current.value);
            inOrder(current.right);
        }
    }

    void postOrder(BinarySearchTreeNode current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.value);
        }
    }

    void levelTraversal() {
        if (root == null)
            return;
        Queue<BinarySearchTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinarySearchTreeNode currentNode = queue.poll();
                System.out.print(currentNode.value + " ");
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            System.out.println();
        }
    }

    public void search(BinarySearchTreeNode currentNode, int value) {
        if (currentNode == null) {
            System.out.println("Node not found");
            return;
        }
        if (currentNode.value == value) {
            System.out.println("Node found");
        } else if (value <= currentNode.value) {
            search(currentNode.left, value);
        } else {
            search(currentNode.right, value);
        }

    }

    public void search(int value) {
        search(root, value);
    }

    public void deleteBST() {
        this.root = null;
    }

    public BinarySearchTreeNode minimumNode(BinarySearchTreeNode current) {
        if (root == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    public BinarySearchTreeNode deleteNode(BinarySearchTreeNode current, int value) {
        if (current == null) {
            System.out.println("Node not found");
            return null;
        }
        if (value < current.value) {
            current.left = deleteNode(current.left, value);
        } else if (value > current.value) {
            current.right = deleteNode(current.right, value);
        } else {
            //node has two children
            /*1) find successor
             * 2) replace node to delete value with successor value
             * 3) delete successor*/
            if (current.left != null && current.right != null) {
                BinarySearchTreeNode temp = current;
                BinarySearchTreeNode minimumNode = minimumNode(current.right);
                current.value = minimumNode.value;
                deleteNode(current.right, minimumNode.value);


                //node has one child
            } else if (current.left != null) {
                current = current.left;


            } else if (current.right != null) {
                current = current.right;
                //leaf node
            } else {
                current = null;
            }

        }
        {
            return current;


        }

    }
}
