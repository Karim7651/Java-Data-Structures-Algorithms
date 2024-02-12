import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addNodeAtEnd(1);
        linkedList.addNodeAtEnd(2);
        linkedList.addNodeAtEnd(1);
        linkedList.addNodeAtEnd(2);
        linkedList.addNodeAtEnd(1);
        linkedList.addNodeAtEnd(2);
        linkedList.printSinglyLinkedList();
        linkedList.removeDuplicatesFromUnsortedLinkedList();
        linkedList.printSinglyLinkedList();
        System.out.println(linkedList.tail.data);
        linkedList.addNodeAtEnd(5);
        linkedList.printSinglyLinkedList();
        SinglyLinkedList.Node nth = linkedList.nthToLastElement(0);
    }
}