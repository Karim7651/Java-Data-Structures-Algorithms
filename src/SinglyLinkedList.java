import java.util.HashSet;

public class SinglyLinkedList {
    public Node head = new Node();
    public Node tail = new Node();

    public int size;

    public class Node {
        int data;
        Node next;

        public Node() {
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public SinglyLinkedList(int data) {
        Node node = new Node(data);
        this.head = this.tail = node;
        size++;
    }

    public void addNodeAtStart(int data) {
        Node node = new Node(data);
        if (head == null)
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addNodeAtEnd(int data) {
        Node node = new Node(data);
        if (head == null)
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insert(int index, int data) {
        if (index > size) {
            System.out.println("invalid index");
            return;
        }
        if (index == 0)
            addNodeAtStart(data);
        if (index == size) {
            addNodeAtEnd(data);
            return;
        }

        Node node = new Node(data);
        int counter = 0;
        for (Node i = head; i != null; i = i.next, counter++) {
            if (counter == index - 1) {
                node.next = i.next;
                i.next = node;
                break;
            }

        }
        size++;
    }

    public void deleteNode(int index) {
        if (index >= size) {
            System.out.println("invalid index");
            return;
        }
        if (index == 0) {
            deleteFirstNode();
            return;
        }
        int counter = 0;
        for (Node i = head; i != null; i = i.next, counter++) {
            if (counter == index - 1) {
                i.next = i.next.next;
                if (index == size - 1)
                    tail = i;
                break;
            }
        }
        size--;
    }

    public void deleteFirstNode() {
        head = head.next;
        size--;
    }

    public void printSinglyLinkedList() {
        for (Node i = head; i != null; i = i.next) {
            System.out.print(i.data);
            if (i.next != null)
                System.out.print(" --> ");
        }
        System.out.println();
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
    }

    public void removeDuplicatesFromUnsortedLinkedList() {
        if (size < 2) {
            System.out.println("no duplicates in a single node linked list !");
        }
        //use hashset to track duplicates
        HashSet<Integer> set = new HashSet<>();
        Node prev = new Node(0);
        prev.next = head;
        for (Node i = head; i != null; i = i.next) {
            int prevData = prev.data;
            int currentData = i.data;
            if (set.contains(i.data)) {
                prev.next = i.next;
                size--;
            } else {
                set.add(i.data);
                prev = prev.next;
            }
        }
        //fix tail is technically not necessary as current = tail = last node but this would be an imaginary node that's not connected to linkedList
        //so it would ruin addToEnd() for example
        fixTail();

    }

    public void fixTail() {
        Node i = head;
        for (; i.next != null; i = i.next) {
        }
        tail = i;
    }

    //Implement and algorithm to find the nth to last element of a singly linked list.
    // assume linked list : 1 -> 2 -> 3 -> 4 -> 5 nthToLast(1) is four
    public Node nthToLastElement(int index) {
        Node fastPointer = head;
        Node slowPointer = head;

        for (int i = 0; i < index; i++) {
            //in cause invalid index is given
            fastPointer = fastPointer.next;
        }
        if (fastPointer == null)
            return null;
        for (; fastPointer.next != null; fastPointer = fastPointer.next, slowPointer = slowPointer.next) {

        }
        return slowPointer;

    }


}
