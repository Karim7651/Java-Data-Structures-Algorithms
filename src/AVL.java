import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BinarySearchTreeNode root;

    public AVL(){
        this.root = null;
    }

    public void preOrder(BinarySearchTreeNode current){
        if(current != null){
            System.out.println(current.value);
            preOrder(current.left);
            preOrder(current.right);
        }
    }
    public void postOrder(BinarySearchTreeNode current){
        if(current != null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.value);
        }
    }
    public void inOrder(BinarySearchTreeNode current){
        if(current != null){
            inOrder(current.left);
            System.out.println(current.value);
            inOrder(current.right);
        }
    }
    public void levelTraversal(){
        if (this.root == null)
            return;
        Queue<BinarySearchTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                BinarySearchTreeNode current = queue.poll();
                System.out.print(current.value);
                if(current.left !=null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }
    public BinarySearchTreeNode search(BinarySearchTreeNode current, int value) {
        if (current == null) {
            return null;
        } else if (value == current.value) {
            return current;
        } else if (value < current.value) {
            return search(current.left, value);
        } else {
            return search(current.right, value);
        }
    }
    //not done yet




}
