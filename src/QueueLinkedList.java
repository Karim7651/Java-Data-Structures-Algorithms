public class QueueLinkedList {
    QNode front,rear;
    public QueueLinkedList(){
        this.front = this.rear = null;
    }
    void enqueue(int val){
        QNode temp = new QNode(val);
        if(this.front == null){
            front = rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
    int dequeue(){
        if(this.isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        int toReturn = this.front.key;
        this.front=this.front.next;
        if(this.front == null)
            this.rear = null;
        return toReturn;

    }
    boolean isEmpty(){
        return this.front == null;
    }
    void printQueue(){
        for(QNode i = this.front ; i != null ; i = i.next){
            System.out.println(i.key);
        }
    }
    public class QNode{
        int key;
        QNode next;
        public QNode(int key){
            this.key = key;
            this.next =  null;
        }
    }

}
