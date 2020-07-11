package com.itheima;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("-------欢迎进入学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出系统");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();

            if (i == 1) {
                System.out.println("欢迎进入添加学生界面");
                addStudent(array);
            } else if (i == 3) {
                System.out.println("欢迎进入修改学生界面");
                changerStudent(array);
            } else if (i == 2) {
                System.out.println("欢迎进入删除学生界面");
                deleStudent(array);
            } else if (i == 4) {
                findStudent(array);
                System.out.println("欢迎进入查看学生界面");
            } else if (i == 5) {
                System.out.println("谢谢使用");
                System.exit(0);
            }
        }
    }


    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            boolean flag = isSued(array, sid);
            if (flag) {
                System.out.println("输入学号已经存在，请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生地址：");
        String address = sc.nextLine();


        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);

    }

    public static void findStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请添加信息再查询");
            /*//为了程序不再往下执行，给出 return,和使用 else 同样效果
            return;*/
        } else {
            System.out.println("学号\t\t\t姓名\t\t年龄\t\t住址");
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getSid() + "\t" + s.getName() + "\t\t" + s.getAge() + "岁\t" + s.getAddress());
            }
        }
    }

    /*
        public static void deleStudent(ArrayList<Student> array){
            System.out.println("请输入学生学号：");
            Scanner sc = new Scanner(System.in);
            String sid = sc.nextLine();
            for (int i = 0; i < array.size(); i++){
                Student s = array.get(i);
                if (s.getSid().equals(sid)){
                    array.remove(i);
                    break;
                }
            }
            System.out.println("该学生数据已经删除成功");
        }
    */
    public static void deleStudent(ArrayList<Student> array) {
        System.out.println("请输入学生学号：");
        Scanner sc = new Scanner(System.in);
        String sid = sc.nextLine();
        int index = -1;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("输入学号不存在，请重新输入");
        } else {
            array.remove(index);
            System.out.println("该学生数据已经删除成功");
        }

    }

    public static void changerStudent(ArrayList<Student> array) {
        System.out.println("输入需要修改学生的学号：");
        Scanner sc = new Scanner(System.in);
        String sid = sc.nextLine();
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = -1;
            }
            if (index == -1) {
                System.out.println("输入学号不存在，请重新输入");
            } else {
                System.out.println("重性输入学生姓名：");
                String name = sc.nextLine();
                System.out.println("重性输入学生年龄：");
                String age = sc.nextLine();
                System.out.println("重性输入学生地址：");
                String address = sc.nextLine();

                Student s1 = new Student();
                s1.setSid(sid);
                s1.setName(name);
                s1.setAge(age);
                s1.setAddress(address);

                array.set(i, s1);
                System.out.println("该学生数据删除成功");
            }
        }
    }

    public static boolean isSued(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
