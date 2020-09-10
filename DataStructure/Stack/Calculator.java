package com.Stack;

public class Calculator {
    public static void main(String[] args) {
        //根据前面老师思路，完成表达式的运算
        //创建两个栈，数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描得到char保存到ch
        String mach = "80*9-2+3";//将每次扫描得到char保存到ch
        String keepNum = "";//用于拼接 多位数
        //开始while循环的扫描match
        while (true) {
            //依次得到expression 的每一个字符
            ch = mach.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) {
                //判断当前的符号栈是否为空
                if (operStack.isEmpty()) {
                    //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                    operStack.add(ch);
                } else {
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.Priority(ch) <= operStack.Priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calculation(num1, num2, oper);
                        //把运算的结果如数栈
                        numStack.add(res);
                        //然后将当前的操作符入符号栈
                        operStack.add(ch);
                    } else {
                        //如果为空直接入符号栈..
                        operStack.add(oper);
                    }
                }
            } else {//如果是数，则直接入数栈
                //numStack.push(ch - 48); //? "1+3" '1' => 1
                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接

                //处理多位数
                keepNum += ch;
                //如果ch已经是expression的最后一位，就直接入栈
                if (index == mach.length() - 1) {
                    numStack.add(ch - 48);
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operStack.isOper(mach.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        numStack.add(Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";
                    }
                }

            }
            //让index + 1, 并判断是否扫描到expression最后
            index++;
            if (index >= mach.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while (true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calculation(num1, num2, oper);
            numStack.add(res);
        }
        //将数栈的最后数，pop出，就是结果
        int res2 = numStack.pop();
        System.out.printf("运算式：%s = %d", mach, res2);
    }
}

//定义一个 ArrayStack 表示栈
class ArrayStack2 {
    private int top = -1;// 栈的大小
    private int[] stack;// 数组，数组模拟栈，数据就放在该数组
    private int maxSize;// top表示栈顶，初始化为-1


    //构造器
    public ArrayStack2(int maxSize) {
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

    public int peek() {
        return stack[top];
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

    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public int Priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return 1;// 假定目前的表达式只有 +, - , * , /
        }
    }

    public boolean isOper(char cal) {
        return cal == '+' || cal == '/' || cal == '*' || cal == '-';
    }

    //计算方法
    public int calculation(int num1, int num2, int oper) {
        int res = 0;// res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
