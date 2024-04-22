 import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BinaryHeap binaryHeap = new BinaryHeap(10,"Max");
        binaryHeap.insert(10);
        binaryHeap.insert(5);
        binaryHeap.insert(15);
        binaryHeap.insert(1);
        binaryHeap.levelOrderTraversal();
    }
}