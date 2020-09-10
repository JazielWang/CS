package com.Queue;

import java.util.Scanner;

public class CirclesArrayDemo {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CirclesArray aq = new CirclesArray(4);//说明设置4, 其队列的有效数据最大是3
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        char key = ' ';// 接收用户输入
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = sc.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    aq.show();
                    break;
                case 'a':
                    System.out.println("请输入一个值：");
                    int i = sc.nextInt();
                    aq.put(i);
                    break;
                case 'g':
                    try {
                        int ii = aq.get();
                        System.out.println("数据是：" + ii);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int iii = aq.head();
                        System.out.println("头部数据时：" + iii);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class CirclesArray {
    private int maxSize;// 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int rear;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int front;// 队列尾
    private int[] arr;// 该数据用于存放数据, 模拟队列

    public CirclesArray(int ArrmaxSize) {
        this.maxSize = ArrmaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void put(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // rear = 2
    // front = 1
    // maxSize = 3
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队伍为空");
        }
        return arr[front];
    }
}