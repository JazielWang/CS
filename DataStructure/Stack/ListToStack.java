package com.Stack;

public class ListToStack {
    public static void main(String[] args) {
        ListStackDemo lsd = new ListStackDemo();

        lsd.add(23);
        lsd.add(56);
        lsd.add(82);
        lsd.add(37);

        lsd.show();
    }
}

class ListStackDemo {
    ListStack head = new ListStack(0);

    public void add(int num) {
        ListStack news = new ListStack(num);
        ListStack temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(news);
    }

    public void pop() {
        if (head.getNext() == null) {
            System.out.println("the stack is empty.");
            return;
        }
        ListStack temp = head.getNext();
        if (temp == null) {
            System.out.println(temp);
            return;
        }
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        System.out.println(temp.getNext());
        temp.setNext(null);
    }

    public void show() {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            System.out.println("this linklist can't to get reverse.");
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        ListStack temp = head.getNext();
        ListStack next = null;// 指向当前节点[cur]的下一个节点
        ListStack reverse = new ListStack(0);
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while (temp != null) {
            next = temp.getNext();//先暂时保存当前节点的下一个节点，因为后面需要使用
            temp.setNext(reverse.getNext());//将cur的下一个节点指向新的链表的最前端
            reverse.setNext(temp); //将cur 连接到新的链表上
            temp = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.setNext(reverse.getNext());
        ListStack temp2 = head.getNext();
        while (temp2 != null) {
            System.out.println(temp2);
            temp2 = temp2.getNext();
        }
    }
}

class ListStack {
    private int num;
    private ListStack next;

    public ListStack(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ListStack getNext() {
        return next;
    }

    public void setNext(ListStack next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListStack{" +
                "num=" + num +
                '}';
    }
}