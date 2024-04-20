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
    public static void selectionSort(int[] array){
        for(int i = 0 ; i < array.length-1 ; i++){
            int minIndex = i;
            for(int j = i ; j < array.length ; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
