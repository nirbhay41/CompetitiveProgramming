package com.RocketScience.DSA.Queue;

//Implementing Circular Queue
public class ArrayQueue {
    private final int size;
    private int front;
    private int rear;
    private final int[] arr;

    public ArrayQueue(int size) {
        this.size = size;
        arr = new int[size+1];
        front = rear = 0;
    }
    public void enqueue(int x){
        if(isFull()){ // If next index is front then queue is full
            throw new RuntimeException("Queue is Full");
        }else{
            rear = (rear+1)%(size+1); // For next index in Circular Queue
            arr[rear] = x;
        }
    }
    public int dequeue(){
        int x = -1;

        if(isEmpty())
            throw new RuntimeException("Queue is Empty");
        else{
            front = (front+1)%(size+1);
            x=arr[front];
        }
        return x;
    }
    public void display(){
        int i = front+1;
        do{
            System.out.println(arr[i]);
            i = (i+1)%(size+1);
        }while (i != (rear+1)%(size+1));
        System.out.println();
    }
    public boolean isFull(){
        return (rear+1) % (size+1) == front;
    }
    public boolean isEmpty(){
        return front == rear;
    }
}
