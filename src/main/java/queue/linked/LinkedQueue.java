package queue.linked;


/**
 * @author Singularity
 * @createTime 2022年04月24日 10:49:00
 * @Description 链表实现队列
 */
public class LinkedQueue {
    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue(){
        front = rear = null;
        size = 0;
    }

    /**
     * @Description 判断队列是否为空
     */
    public boolean isEmpty(){
        return front == null;
    }

    /**
     * @Description 入队
     */
    public void addQueue(Object element){
        Node node = new Node(element);
        if (isEmpty()){
            front = node;
        }else {
            rear.next = node;
        }
        rear = node;//更新尾节点
        size++;
    }

    /**
     * @Description  出队
     */
    public Object removeQueue(){
        Object temp = null;
        if (isEmpty()){
            new NullPointerException("queue is empty!");
        }else {
            temp = front.data;
            front = front.next;
            size--;
        }
        return temp;
    }

    public static void main(String[] args){
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.addQueue(3);
        linkedQueue.addQueue(2);
        linkedQueue.addQueue(1);
        while (!linkedQueue.isEmpty()){
            System.out.println(linkedQueue.removeQueue());
        }
    }

}
