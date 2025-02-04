 import java.util.ArrayList;
 import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        // Insert values into the min heap
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(25);

        // Extract and print the minimum values from the heap
        System.out.println("Extracted Max: " + maxHeap.extractMax());
        System.out.println("Extracted Max: " + maxHeap.extractMax());
    }
    public static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            boolean isSwapped= false;
            for(int j = 0 ; j < arr.length - i - 1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static void insertionSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            int temp = arr[i];
            int j = i;
            //shift bigger to the right
            while(j > 0 &&  arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    public static void mergeSort(int[] arr){
        int inputSize = arr.length;
        if(inputSize < 2)
            return;
        int midPoint = arr.length/2;
        int[] leftHalf = new int[midPoint];
        int[] rightHalf = new int[inputSize - midPoint];
        for(int i = 0 ; i < midPoint ; i++){
            leftHalf[i] = arr[i];
        }
        for(int i = midPoint ; i < inputSize ; i++){
            rightHalf[i-midPoint] = arr[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(leftHalf,rightHalf,arr);
    }
    public static void merge(int[] leftHalf,int[] rightHalf,int[] arr){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0 , j = 0, k= 0;
        while(i < leftSize && j < rightSize){
            if(leftHalf[i] < rightHalf[j]){
                arr[k] = leftHalf[i++];
            }else{
                arr[k] = rightHalf[j++];
            }
            k++;
        }
        while(i < leftSize){
            arr[k] = leftHalf[i++];
        }
        while(j < rightSize){
            arr[k] = rightHalf[j++];
        }
    }
    public static void quickSort(int[] arr,int lowIndex, int highIndex){
        if(lowIndex>=highIndex)
            return;

        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
        while(leftPointer < rightPointer){
            while(arr[leftPointer] <= pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while(arr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            int temp = arr[leftPointer];
            arr[leftPointer] = arr[rightPointer];
            arr[rightPointer] = temp;
        }
        int temp = arr[highIndex];
        arr[highIndex] = arr[leftPointer];
        arr[leftPointer] = temp;
        quickSort(arr,lowIndex,leftPointer-1);
        quickSort(arr,rightPointer+1,highIndex);
    }

}