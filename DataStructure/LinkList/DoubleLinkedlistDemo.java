package com.LinkList;

public class DoubleLinkedlistDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList dll = new DoubleLinkedList();

        /*dll.add(hero1);
        dll.add(hero2);
        dll.add(hero3);
        dll.add(hero4);
        dll.show();

        System.out.println();
        HeroNode2 hero5 = new HeroNode2(4, "公孙胜", "入云龙");
        dll.set(hero5);
        dll.show();

        System.out.println();
        dll.delete(hero2);
        dll.show();*/

        dll.orderAdd(hero1);
        dll.orderAdd(hero4);
        dll.orderAdd(hero3);
        dll.orderAdd(hero2);
        dll.show();
    }
}

class HeroNode2 {
    public int No;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        No = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "No=" + No +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class DoubleLinkedList{
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //显示链表[遍历]
    public void show() {
        if (head.next == null) {
            System.out.println("the linklist is empty");
            return;
        }

        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (temp != null) {
            //判断是否到链表最后
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void orderAdd(HeroNode2 heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
        boolean flag = false;// flag标志添加的编号是否存在，默认为false

        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.No > heroNode.No) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.No == heroNode.No) {//说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag 的值
        if (flag) {//不能添加，说明编号存在
            System.out.println("数据" + heroNode.No + "号已经存在，无需添加");
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
            if (temp.next.next != null) {
                temp.next.next.pre = heroNode;
            }
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void set(HeroNode2 heroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("The linklist is empty.");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.No == heroNode.No) {
                flag = true;
                break;//找到
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.println("没有找到你要更改的数据" + heroNode.No + "号");
        }
    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void delete(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.No == heroNode.No) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 无法使用 heroNode.next 是因为虽然内容相同，但是它还没有进入链表，所以他的next是null
            temp.pre.next = heroNode.next;
            if (temp.next != null){
                temp.next.pre = heroNode.pre;
            }
        } else {
            System.out.println("需要删除的数据存在");
        }
    }
}