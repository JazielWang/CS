package com.Stack;

import java.util.Scanner;

public class ArrayToStack {
    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack as = new ArrayStack(4);
        Scanner sc = new Scanner(System.in);
        String key = "";
        boolean flag = true;//控制是否退出菜单
        while (flag) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("add: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = sc.next();
            switch (key) {
                case "show":
                    as.show();
                    break;
                case "add":
                    System.out.println("please put in a num.");
                    int num = sc.nextInt();
                    as.add(num);
                    break;
                case "pop":
                    try {
                        int s = as.pop();
                        System.out.printf("data is %d\n", s);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    sc.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}

//定义一个 ArrayStack 表示栈
class ArrayStack {
    private int top = -1;// 栈的大小
    private int[] stack;// 数组，数组模拟栈，数据就放在该数组
    private int maxSize;// top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("the stack is full.");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("the stock is empty.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d", i, stack[i]);
            System.out.println();
        }
    }
}