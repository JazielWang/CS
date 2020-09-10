package com.Queue;

public class ArrayQueue {
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;

    public ArrayQueue(int arrMixsize) {
        this.maxSize = arrMixsize;
        arr = new int[arrMixsize];
        rear = -1;
        front = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void put(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        arr[++rear] = n;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队伍为空");
        }
        return arr[front + 1];
    }
}
