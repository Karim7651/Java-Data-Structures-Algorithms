public class BinaryHeap {
    //left child = this.index * 2
    //right child = this.index * 2 + 1
    //this.parent = this.index / 2
    int[] arr;
    int sizeOfTree;
    String heapType;

    public BinaryHeap(int size,String typeOfHeap) {
        //since we're going to use 1-indexed binary heap we'd add one to the size of the array
        this.arr = new int[size + 1];
        this.sizeOfTree = 0;
        this.heapType = typeOfHeap;
    }


    public boolean isEmpty() {
        return sizeOfTree == 1;
    }

    public int peek() {
        if (!isEmpty())
            return this.arr[1];
        System.out.print("Heap is empty");
        return -1;
    }

    public int size() {
        return this.sizeOfTree;
    }

    public void levelOrderTraversal() {
        //O(N)
        for (int i = 1; i <= this.sizeOfTree; i++) {
            System.out.print(this.arr[i] + " ");
        }
    }

    //heapify takes two parameters
    //index of this node
    //type of heap
    //O(LOG(N))
    //O(LOG(heapSize))
    public void heapifyBottomToTop(int index){
        int parent = index/2;
        if(index <= 1)
            return;
        if(heapType.equals("Min") ){
            if(this.arr[index] < this.arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }else if(heapType.equals("Max") ){
            if(arr[index] > arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBottomToTop(parent);
    }
    public void insert(int value){
        if(sizeOfTree == arr.length-1){
            System.out.print("heap is full");
            return;
        }
        arr[++sizeOfTree] = value;
        heapifyBottomToTop(sizeOfTree);
    }

}
