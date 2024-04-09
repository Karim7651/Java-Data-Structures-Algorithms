import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedList {
    BinaryNode root;
     public BinaryTreeLinkedList(){
         this.root = null;
     }
     public void preOrder(BinaryNode node){
         if(node != null){
             System.out.println(node.value);
             preOrder(node.left);
             preOrder(node.right);
         }

     }
     public void inOrder(BinaryNode node){
         if(node != null){
             inOrder(node.left);
             System.out.println(node.value);
             inOrder(node.right);
         }
     }
     public void postOrder(BinaryNode node){
         if(node != null){
             postOrder(node.left);
             postOrder(node.right);
             System.out.println(node.value);
         }
     }
     public void levelTraversal(){
         Queue<BinaryNode> queue = new LinkedList<>();
         if(root == null)
             return;
         queue.add(root);
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i = 0 ; i < size ; i++) {
                 BinaryNode currentNode = queue.poll();
                 System.out.print(currentNode.value);
                 if (currentNode.left != null)
                     queue.add(currentNode.left);
                 if (currentNode.right != null)
                     queue.add(currentNode.right);
             }
         }
     }
    public void search(String value){
         if(root == null){
             System.out.println("Tree is empty");
         }
         Queue<BinaryNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i = 0 ; i < queue.size(); i++){
                 BinaryNode currentNode = queue.poll();
                 if(currentNode.value.equals(value)){
                     System.out.println("found node");
                     return;
                 }
                 if(currentNode.left != null)
                     queue.add(currentNode.left);
                 if(currentNode.right != null)
                     queue.add(currentNode.right);
             }

         }
         System.out.println("node not found");


    }
    public void insert(String value){
         BinaryNode newNode = new BinaryNode(value);
         if(root == null){
             root = newNode;
             return;
         }
         Queue<BinaryNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i = 0 ; i < queue.size() ; i++){
                 BinaryNode currentNode = queue.poll();
                 if(currentNode.left == null){
                     currentNode.left = newNode;
                     return;
                 }
                 if(currentNode.right == null){
                     currentNode.right = newNode;
                 }
                 if(currentNode.left != null)
                     queue.add(currentNode.left);
                 if(currentNode.right != null)
                     queue.add(currentNode.right);
             }
         }
    }
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    //VI
    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode,currentNode = null;
        while(!queue.isEmpty()){
            previousNode = currentNode;
            currentNode = queue.poll();
            if(currentNode.left == null){
                previousNode.right = null;
                return;
            }
            if(currentNode.right==null){
                currentNode.left= null;
                return;
            }
            queue.add(currentNode.left);
            queue.add(currentNode.right);

        }
    }

    // Delete Given node
    void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node is deleted!");
                return;
            } else {
                if (presentNode.left != null) queue.add(presentNode.left);
                if (presentNode.right != null) queue.add(presentNode.right);
            }
        }
        System.out.println("The node does not exist in this BT");
    }

    // Delete Binary Tree
    void deleteBT() {
        root = null;
        System.out.println("BT has been successfully deleted!");
    }

}

/*
* public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null){
            return output;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }
            output.add(currentLevel);
        }
        return output;
    }*/
