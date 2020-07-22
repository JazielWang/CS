package com.ItHeima_javabase_06;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo_05 {
    public static void main(String[] args) {
        ArrayList<StudentClass> array = new ArrayList<StudentClass>();
        addStudent(array);
        addStudent(array);
        addStudent(array);

        for (int i = 0; i< array.size(); i++){
            StudentClass s = array.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
    }

    public static void addStudent(ArrayList<StudentClass> array){
        System.out.println("请输入学生姓名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();


        StudentClass s = new StudentClass();
        s.setName(name);
        s.setAge(age);

        array.add(s);
    }
}
