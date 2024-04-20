import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] x = {5,4,5,3,2,1,6,6,6,6,6,3,2,1,24};
        Sorting.selectionSort(x);
        Sorting.printArray(x);
    }
}