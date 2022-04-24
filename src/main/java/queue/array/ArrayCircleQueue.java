package queue.array;

import java.util.Arrays;
/**
 * @author Singularity
 * @createTime 2022年04月20日 15:06:00
 * @Description 队列_数组实现
 */
public class ArrayCircleQueue {
    private Object[] items;
    private int front;
    private int rear;
    private int size;
    private boolean flag;
    public ArrayCircleQueue(int size){
        items = new Object[size];
        this.size = size;
    }

    public static void main(String[] args){
        int[] array1  = {1,2,3,4,5,6,7,8};
        int size = array1.length;
        ArrayCircleQueue arrayCircleQueue = new ArrayCircleQueue(size);
        Arrays.stream(array1).forEach(arrayCircleQueue::enqueue);
        for(int i = 0;i<size;i++){
            System.out.println(arrayCircleQueue.dequeue());
        }
        Arrays.stream(array1).forEach(arrayCircleQueue::enqueue);
        for(int i = 0;i<size;i++){
            System.out.println(arrayCircleQueue.dequeue());
        }
    }

    //入队
    public void enqueue(Object item){
        if (front == rear && flag){
            throw new RuntimeException("queue is full");
        }
        front = front % size;
        items[front] = item;
        front++;
        if (front == rear){
            flag = true;
        }
    }

    //出队
    public Object dequeue(){
        if (front == rear && !flag){
            throw new RuntimeException("queue is empty");
        }
        rear = rear % size;
        Object item = items[rear];
        rear++;
        if (front==rear){
           flag = false;
        }
        return item;
    }

}
