import java.util.*;
public class GreedyAlgorithms {


    public static void activitySelection(ArrayList<Activity> activityList){
        /*
        sort by finishing time
        O(Nlog(N))
        O(1)
        */
        Comparator<Activity> comparator = new Comparator<>() {
            @Override
            public int compare(Activity o1,Activity o2) {
                return o1.getFinishTime()-o2.getFinishTime();
            }
        };
        Collections.sort(activityList,comparator);
        Activity prevActivity = activityList.get(0);
        System.out.println(prevActivity);
        for(int i = 1 ; i < activityList.size();i++){
            Activity currentActivity = activityList.get(i);
            if(currentActivity.getStartTime() >= prevActivity.getFinishTime()){
                System.out.println(currentActivity);
                prevActivity = currentActivity;
            }else{
                continue;
            }
        }
    }

    public static int coinChange(int totalMoney , int[] denominations){
        int counter = 0;
        Arrays.sort(denominations);
        int index = denominations.length - 1;
        while(true){
            int coinValue = denominations[index];
            index --;
            //number * value
            int maxAmount = (totalMoney/coinValue)*coinValue;
            if(maxAmount > 0){
                System.out.println("took " + (totalMoney/coinValue) + " from " + coinValue);
                counter += totalMoney/coinValue;
                totalMoney-= maxAmount;

            }
            if(totalMoney == 0){
                return counter;
            }
        }
    }

    //O(NlogN + N)
    //O(1)
    public static void fractionalKnapsack(ArrayList<KnapsackItem> items,int capacity){
        //sort according to descending order
        Comparator<KnapsackItem> comparator = new Comparator<KnapsackItem>() {
            @Override
            public int compare(KnapsackItem o1, KnapsackItem o2) {
                if(o2.getRatio() > o1.getRatio()) return 1;
                else return -1;
            }
        };
        Collections.sort(items,comparator);
        int usedCapacity = 0;
        double value = 0;
        for(KnapsackItem item : items){
            if(capacity-usedCapacity >= item.getWeight()){
                usedCapacity+=item.getWeight();
                value+= item.getValue();
                System.out.println("Took : " + item);
            }else{
                int takenWeight = capacity-usedCapacity;
                double gainedValue =  item.getRatio()*takenWeight;
                usedCapacity += takenWeight;
                value += gainedValue;
            }
            if(usedCapacity==capacity) break;
        }
        System.out.println("value : " + value);
    }
}
