public class MinStack {
    Node top;
    Node min;
    public MinStack(){
        this.top = null;
        this.min = null;
    }
    public class Node{
        int value;
        Node next;
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    public int min(){
        return this.min.value;
    }
    public void push(int value){
        if(min == null){
            //points towards itself
            min = new Node(value,min);
        }else if(min.value < value){
            min = new Node(min.value,min);
            //new minimum
        }else{
            min = new Node(value,min);
        }
        top = new Node(value,top);
    }
    public int pop(){
        min = min.next;
        int result = top.value;
        top = top.next;
        return result;
    }

}
