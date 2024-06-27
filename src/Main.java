 import java.util.ArrayList;
 import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] x = {
                {4,7,1,6},
                {5,7,3,9},
                {3,2,1,2},
                {7,1,6,3}
        };
        System.out.println(DivideAndConquer.numberOfPathsToReachLastCellWithGivenCost(x,0,0,25));
    }
}