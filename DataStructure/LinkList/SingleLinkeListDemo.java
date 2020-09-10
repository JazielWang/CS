package com.LinkList;

import java.util.Stack;

public class SingleLinkeListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        SingleLinkList sll = new SingleLinkList();
        SingleLinkList sll2 = new SingleLinkList();

        /*sll.add(hero1);
        sll.add(hero2);
        sll.add(hero3);
        sll.add(hero4);*/

        //加入按照编号的顺序
        sll.orderAdd(hero1);
        sll.orderAdd(hero3);
        sll.show();
        sll2.orderAdd(hero2);
        sll2.orderAdd(hero4);
        sll2.show();

        System.out.println();

        /*//测试修改节点的代码
        HeroNode hero5 = new HeroNode(3, "小吴", "智多星~~");
        sll.set(hero5);
        sll.show();

        //删除一个节点
        System.out.println();
        HeroNode hero6 = new HeroNode(1, "宋江", "及时雨");
        sll.delete(hero6);
        sll.show();

        //测试一下 求单链表中有效节点的个数
        System.out.println("有效数据数是：" + getLength(sll.getHead()));
        //测试一下看看是否得到了倒数第K个节点
        System.out.println(getLastNode(sll.getHead(), 1));*/

        /*System.out.println("反转单链表~~");
        getReverse(sll.getHead());
        sll.show();*/

        //反转方法2
//        getReverse2(sll.getHead());

        //合并链表
        SingleLinkList merge = toMerge(sll.getHead(), sll2.getHead());
        merge.show();
    }

    //合并两个链表
    public static SingleLinkList toMerge(HeroNode head1, HeroNode head2) {
        if (head1.next == null || head2.next == null) {
            System.out.println("one of the herohode is empty.");
        }
        SingleLinkList merge = new SingleLinkList();
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        HeroNode next = new HeroNode(0, "", "");

        // 此处必须利用一个新的对象接收一下next之后的链表，在orderAdd方法中（heronode.next = temp.next），
        // 所以,会将temp1所链接的链表切断，所以就会产生null
        while (temp1 != null) {
            next = temp1.next;
            merge.orderAdd(temp1);
            temp1 = next;
        }
        while (temp2 != null) {
            next = temp2.next;
            merge.orderAdd(temp2);
            temp2 = next;
        }
        return merge;
    }

    //方式2：
    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void getReverse2(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode temp = head.next;
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        //将链表的所有节点压入栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;//cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());//stack的特点是先进后出
        }
    }

    //方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    /**
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            System.out.println("the linklist is empty.");
            return 0;
        }
        HeroNode temp = head.next;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //查找单链表中的倒数第k个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示是倒数第index个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回nulll
    public static HeroNode getLastNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            System.out.println("the likelist is empty.");
            return null;
        }
        HeroNode temp = head.next;
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void getReverse(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            System.out.println("this linklist can't to get reverse.");
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode temp = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverse = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while (temp != null) {
            next = temp.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            temp.next = reverse.next;//将cur的下一个节点指向新的链表的最前端
            reverse.next = temp; //将cur 连接到新的链表上
            temp = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverse.next;
    }
}

class HeroNode {
    public int No;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
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

//定义SingleLinkedList 管理我们的英雄
class SingleLinkList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    //显示链表[遍历]
    public void show() {
        if (head.next == null) {
            System.out.println("the linklist is empty");
            return;
        }

        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            //判断是否到链表最后
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void orderAdd(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
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
            temp.next = heroNode;
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void set(HeroNode heroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("The linklist is empty.");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
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
    public void delete(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.No == heroNode.No) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 无法使用 heroNode.next 是因为虽然内容相同，但是它还没有进入链表，所以他的next是null
            temp.next = temp.next.next;
        } else {
            System.out.println("需要删除的数据存在");
        }
    }
}