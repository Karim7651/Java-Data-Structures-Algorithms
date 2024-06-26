 import java.util.ArrayList;
 import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<KnapsackItem> items = new ArrayList<>();
        int[] value = {100,120,60};
        int[] weight ={20,30,10};
        int capacity = 50;
        for(int i = 0 ; i < 3 ; i++){
            items.add(new KnapsackItem(i+1,value[i],weight[i]));
        }
        GreedyAlgorithms.fractionalKnapsack(items,capacity);

    }
}