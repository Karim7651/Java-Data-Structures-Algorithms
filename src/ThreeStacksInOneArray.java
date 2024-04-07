public class ThreeStacksInOneArray {
    int numberOfStacks = 3;
    int stackCapacity;

    //the actual values stored in the three stacks
    int[] values;

    //track the size of each stack
    int[] size;
    public ThreeStacksInOneArray(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize*3];
        size = new int[stackSize];
    }
    //stackNumber is zero indexed
    public boolean isFull(int stackNumber){
        return size[stackNumber] == stackCapacity;
    }
    public boolean isEmpty(int stackNumber){
        return size[stackNumber] == 0;
    }
    public void printStack(int stackNumber){
        //-1 prints all stacks values
        if(stackNumber == -1){
            for(int i = 0 ; i < values.length ; i++)
                System.out.println(values[i]);
        }else{
            for(int i = stackNumber ; i < stackNumber+3 ; i++ ){
                System.out.println(values[i]);
            }
        }
    }

    public void push(int stackNumber , int value){
        if(isFull(stackNumber)){
            System.out.println("Stack is full !");
            return;
        }
        int targetIndex = size[stackNumber];
        values[targetIndex] = value;
        size[stackNumber]++;
    }
    public int peek(int stackNumber){
        if(isEmpty(stackNumber)){
            System.out.println("This Stack is empty !");
            return -1;
        }
        int targetIndex = size[stackNumber];
        return values[targetIndex];
    }
    public int pop(int stackNumber){
        if(isEmpty(stackNumber)){
            System.out.println("This Stack is empty !");
            return -1;
        }
        int targetIndex = size[stackNumber]-1;
        size[stackNumber]--;
        int toReturn = values[targetIndex];
        values[targetIndex] = 0;
        return toReturn;
    }
}
