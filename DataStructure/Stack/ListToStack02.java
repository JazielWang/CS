package com.Stack;

public class ListToStack02 {
    public static void main(String[] args) {
        ListToStackDemo02 lsd = new ListToStackDemo02();

        ListStack2 ls1 = new ListStack2(23);
        ListStack2 ls2 = new ListStack2(56);
        ListStack2 ls3 = new ListStack2(89);
        ListStack2 ls4 = new ListStack2(25);

        lsd.add(ls1);
        lsd.add(ls2);
        lsd.add(ls3);
        lsd.add(ls4);

        lsd.show();

        System.out.println();
        ListStack2 pop = lsd.pop();
        System.out.println(pop);
        lsd.show();

        System.out.println();
        lsd.delete(89);
        lsd.show();
    }
}

class ListToStackDemo02 {
    ListStack2 head = new ListStack2(0);

    public void add(ListStack2 listStack) {
        if (head.getNext() == null) {
            head.setNext(listStack);
        }else {
            // 使用倒插法插入数据，这样前面的元素都是新插入的
            // 首先常见一个临时的链表接收head之后的数据
            ListStack2 temp = head.getNext();
            // 把新加入的数组接到head之后
            head.setNext(listStack);
            // 把之前临时对象接收的数据连接到新插入数据的后面
            listStack.setNext(temp);
        }
    }

    public void show() {
        if (head.getNext() == null) {
            return;
        }
        ListStack2 temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public void delete(int num) {
        if (head.getNext() == null) {
            return;
        }
        ListStack2 temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getNum() == num) {
                temp.setNext(temp.getNext().getNext());
                System.out.println("数据已经删除");
                break;
            }
            temp = temp.getNext();
        }
    }

    public ListStack2 pop() {
        if (head.getNext() == null) {
            return null;
        }
        ListStack2 temp = head;
        ListStack2 temp2 = null;
        temp2 = temp.getNext();
        temp.setNext(temp.getNext().getNext());
        return temp2;
    }
}

class ListStack2 {
    private int num;
    private ListStack2 next;

    public ListStack2(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ListStack2 getNext() {
        return next;
    }

    public void setNext(ListStack2 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListStack{" +
                "num=" + num +
                '}';
    }
}