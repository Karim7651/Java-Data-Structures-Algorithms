import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> heap ;
    public MaxHeap(){
        heap = new ArrayList<>();
    }
    private int parent(int i ){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return 2*i + 1;
    }
    private int rightChild(int i){
        return 2*i +2;
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    private void swap(int i , int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    public void insert(int value){
        //add at the end
        heap.add(value);
        int currentIndex = heap.size()-1;
        int parent = parent(currentIndex);
        while(currentIndex >0 && heap.get(currentIndex) > heap.get(parent)){
            swap(currentIndex,parent);
            currentIndex = parent;
            parent = parent(currentIndex);
        }

    }
    public int extractMax(){
        if(isEmpty())
            throw new RuntimeException("Heap is empty");
        int max = heap.get(0);
        int last = heap.removeLast();

        if(!heap.isEmpty()){
            heap.set(0,last);
            int currentIndex = 0;
            while(true){
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);
                int largest = currentIndex;
                if(left < heap.size() && heap.get(left) > heap.get(currentIndex)){
                    largest = left;
                }
                if(right < heap.size() && heap.get(right) > heap.get(currentIndex)){
                    largest = right;
                }
                if(largest==currentIndex)
                    break;
                swap(currentIndex,largest);
                currentIndex = largest;
            }
        }
        return max;
    }
}
