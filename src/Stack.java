public class Stack {
    int[] arr;
    int topOfStack;
    public Stack(int size){
        this.arr = new int[size];
        this.topOfStack = -1;
    }
    public boolean isEmpty(){
        return topOfStack == -1;
    }
    public boolean isFull(){
        return topOfStack == arr.length - 1 ;
    }
    public void push(int val){
        if(this.isFull())
            System.out.println("stack is full");
        else{
            topOfStack++;
            arr[topOfStack] = val;
        }
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            System.out.println(arr[topOfStack]);
        }
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            int toReturn = arr[topOfStack];
            arr[topOfStack] = 0;
            topOfStack--;
            return toReturn ;
        }
    }

    public void deleteStack(){
        arr = new int[arr.length];
    }
    public void showStackContent(){
        for(int i = 0 ; i <arr.length ; i ++){
            System.out.println(arr[i]);
        }
    }


}
