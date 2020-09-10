package com.HashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab ht = new HashTab(7);
        //写一个简单的菜单
        Scanner sc = new Scanner(System.in);
        String key = "";
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("dele: 删除雇员");
            System.out.println("exit: 退出系统");
            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("please plunge emp's id");
                    int id = sc.nextInt();
                    System.out.println("please plunge emp's name");
                    String name = sc.next();
                    Emp emp = new Emp(id, name);
                    ht.add(emp);
                    break;
                case "list":
                    ht.list();
                    break;
                case "find":
                    System.out.println("Please, plunge the id that you want to find.");
                    id = sc.nextInt();
                    ht.fundemp(id);
                    break;
                case "dele":
                    System.out.println("Please, plunge the id that you want to delete.");
                    id = sc.nextInt();
                    ht.deleemp(id);
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    //创建HashTab 管理多条链表
    static class HashTab {
        private EmpLinkedList[] empLinkedList;
        private int size;//表示有多少条链表

        //构造器
        public HashTab(int size) {
            this.size = size;
            //初始化empLinkedListArray
            empLinkedList = new EmpLinkedList[size];
            //？留一个坑, 这时不要分别初始化每个链表
            for (int i = 0; i < size; i++) {
                empLinkedList[i] = new EmpLinkedList();
            }
        }

        //添加雇员
        public void add(Emp emp) {
            //根据员工的id ,得到该员工应当添加到哪条链表
            int empLinkedListNo = hashFun(emp.id);
            //将emp 添加到对应的链表中
            empLinkedList[empLinkedListNo].add(emp);
        }

        //遍历所有的链表,遍历hashtab
        public void list() {
            for (int i = 0; i < size; i++) {
                empLinkedList[i].list(i);
            }
        }

        //根据输入的id,查找雇员
        public void fundemp(int id) {
            //使用散列函数确定到哪条链表查找
            int empLinkedListNo = hashFun(id);
            Emp emp = empLinkedList[empLinkedListNo].fund(id);
            if (emp != null) {//找到
                System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNo + 1), id);
            } else {
                System.out.println("we don't find the id.");
            }
        }

        public void deleemp(int id) {
            int emLinkedListNo = hashFun(id);
            empLinkedList[emLinkedListNo].dele(id);
        }

        //编写散列函数, 使用一个简单取模法
        public int hashFun(int id) {
            return id % size;
        }
    }

    //表示一个雇员
    static class Emp {
        public int id;
        public String name;
        public Emp next;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    //创建EmpLinkedList ,表示链表
    static class EmpLinkedList {
        //头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
        private Emp head; //默认null

        //添加雇员到链表
        //说明
        //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
        //   因此我们将该雇员直接加入到本链表的最后即可
        public void add(Emp emp) {
            //如果是添加第一个雇员
            Emp temp = head;
            if (head == null) {
                head = emp;
                return;
            }
            //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
            while (temp.next != null) {//说明到链表最后
                temp = temp.next;//后移
            }
            temp.next = emp;//退出时直接将emp 加入链表
        }

        //遍历链表的雇员信息
        public void list(int No) {
            if (head == null) {//说明链表为空
                System.out.println("No." + (No + 1) + "list is empty.");
                return;
            }
            Emp temp = head;
            System.out.print("No." + (No + 1) + " list is");
            while (true) {
                System.out.printf(" => id=%d name=%s\t", temp.id, temp.name);
                if (temp.next == null) {//说明curEmp已经是最后结点
                    break;
                }
                temp = temp.next;//后移，遍历
            }
            System.out.println();
        }

        //根据id查找雇员
        //如果查找到，就返回Emp, 如果没有找到，就返回null
        public Emp fund(int id) {
            //判断链表是否为空
            if (head == null) {
                System.out.println("the list is empty.");
                return null;
            }
            Emp temp = head;
            while (true) {
                if (temp.id == id) {//找到
                    break;//这时curEmp就指向要查找的雇员
                }
                //退出
                if (temp.next == null) {//说明遍历当前链表没有找到该雇员
                    temp = null;
                    break;
                }
                temp = temp.next;
            }
            return temp;
        }

        public void dele(int id) {
            if (head == null) {
                System.out.println("this list is empty, nothing to delete.");
            }
            Emp temp = head;
            while (true) {
                if (temp.id == id) {
                    break;
                }
                if (temp.next == null) {
                    System.out.println("Don't find the id of " + id);
                    break;
                }
                temp = temp.next;
            }
            head = temp.next;

        }
    }
}
