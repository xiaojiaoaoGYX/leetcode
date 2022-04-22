package queue;

import java.util.Arrays;

/**
 * @author Singularity
 * @createTime 2022年04月20日 14:13:00
 * @Description 队列——数组实现1
 */
public class ArraySimpleQueue {

    private Object[] items;
    private int front;
    private int rear;
    private int size;

    public ArraySimpleQueue(int size){
        items = new Object[size];
        this.size = size;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8};
        int length = array.length;
        ArraySimpleQueue simpleQueue = new ArraySimpleQueue(array.length);
        Arrays.stream(array).forEach(simpleQueue::enqueue);
        for(int i = 0;i<length;i++){
            System.out.println(simpleQueue.dequeue());
        }
        Arrays.stream(array).forEach(simpleQueue::enqueue);
    }

    //入队
    public void enqueue(Object item){
        if (front == rear){
            throw new RuntimeException("queue is full");
        }
        items[front] = item;
        front++;
    }

    //出队
    public Object dequeue(){
        if (front == rear){
            throw new RuntimeException("queue is empty");
        }
        Object item = items[rear];
        rear++;
        return item;
    }
}
