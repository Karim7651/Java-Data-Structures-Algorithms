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
     public void levelTraversal(BinaryNode node){
         Queue<BinaryNode> queue = new LinkedList<>();
         if(node == null)
             return;
         queue.add(node);
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i = 0 ; i < size ; i++) {
                 BinaryNode currentNode = queue.poll();
                 System.out.print(currentNode.value);
                 if (node.left != null)
                     queue.add(node.left);
                 if (node.right != null)
                     queue.add(node.right);
             }
         }
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
