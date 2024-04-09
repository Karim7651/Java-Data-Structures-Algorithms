public class BinaryTreeArray {
    // we are going to implement it using 1 indexed array, it makes calculation easier
    String[] arr;
    int lastUsedIndex;

    BinaryTreeArray(int size) {
        //since this arr index 0 isn't used
        this.arr = new String[size + 1];
        this.lastUsedIndex = 0;
    }

    boolean isFull() {
        return (arr.length == lastUsedIndex + 1);
    }

    void insert(String value) {
        if (!isFull()) {
            arr[++lastUsedIndex] = value;
        } else {
            System.out.println("BT is full");
        }
    }

    //root left right
    public void preOrder(int index) {
        if (lastUsedIndex < index)
            return;
        System.out.println(arr[index]);
        preOrder(index * 2); //left
        preOrder(index * 2 + 1); // right
    }

    //left root right
    public void inOrder(int index) {
        if (lastUsedIndex < index)
            return;
        inOrder(index * 2);
        System.out.println(arr[index]);
        inOrder(index * 2 + 1);
    }

    //left right root
    public void postOrder(int index) {
        if (lastUsedIndex < index)
            return;
        inOrder(index * 2);
        inOrder(index * 2 + 1);
        System.out.println(arr[index]);
    }
    public void levelTraversal(){
        for(int i = 1 ; i <arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
    public int search(String value){
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i].equals(value))
                return i;
        }
        return -1;
    }
    public void delete(String value){
        int location = search(value);
        if(location == -1)
            return;
        arr[location] = arr[lastUsedIndex];
        lastUsedIndex--;
        System.out.println("Node deleted");
    }

}
