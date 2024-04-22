public class Sorting {

    //compare each 2 adjacent elements as biggest element bubbles its way up
    //repeat this n-1 times
    //O(n^2) O(1)
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //smallest element is selected and is moved to the first index
    //repeat n-1 times
    //O(n^2) O(1)
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    //{5,4,0}
    //{5,5,0}
    //{4,5,0}
    //{4,5,5}
    //{4,4,5}
    //{0,4,5}
    //O(N^2) O(1)
    public static void insertionSort(int[] array) {
        //the current element to be put in place in the sorted part (left)
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            //while we're still in the array
            // and the element we're looking to put in place is still smaller than the previous one
            while (j > 0 && array[j - 1] > temp) {
                //shift bigger element(s) to the right
                array[j] = array[j - 1];
                j--;
            }
            //put element in its place
            array[j] = temp;
        }
    }

    //this is for divide part of the algorithm
    public static void mergeSort(int[] array) {
        int inputLength = array.length;
        if (inputLength < 2)
            return;
        int midPoint = array.length / 2;
        int[] leftHalf = new int[midPoint];
        //handle odd arrays
        int[] rightHalf = new int[inputLength - midPoint];

        //populate arrays with elements from the input array
        for (int i = 0; i < midPoint; i++) {
            leftHalf[i] = array[i];
        }
        for (int i = midPoint; i < inputLength; i++) {
            rightHalf[i - midPoint] = array[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(leftHalf, rightHalf, array);
    }

    private static void merge(int[] leftHalf, int[] rightHalf, int[] inputArray) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        //populate input array with sorted elements from leftHalf and rightHalf
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        //make sure there's nothing left in the left or right halves
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            k++;
            j++;
        }


    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        //when it comes to sorting one element
        if(lowIndex >= highIndex)
            return;
        //choose pivot as last index always
        int pivotValue = array[highIndex];
        // partitioning (put elements less than pivotValue to the left of it and elements greater than pivot to the right of it)
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while(leftPointer < rightPointer){
            while(array[leftPointer] <= pivotValue && leftPointer < rightPointer){
                leftPointer++;
            }
            while(array[rightPointer] >= pivotValue && leftPointer < rightPointer){
                rightPointer--;
            }
            swapNumbersInArray(array,leftPointer,rightPointer);
        }
        //swap leftPointer with pivot located at highIndex
        swapNumbersInArray(array,leftPointer,highIndex);
        //pivot is not at leftPointer Index
        quickSort(array,lowIndex,leftPointer-1);
        quickSort(array,leftPointer+1,highIndex);

    }
    private static void swapNumbersInArray(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
