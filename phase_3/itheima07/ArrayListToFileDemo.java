package com.itheima07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
    需求：
        把ArrayList集合中的学生数据写入到文本文件。要求：每一个学生对象的数据作为文件中的一行数据
        格式：学号,姓名,年龄,居住地	举例：itheima001,林青霞,30,西安

    思路：
        1:定义学生类
        2:创建ArrayList集合
        3:创建学生对象
        4:把学生对象添加到集合中
        5:创建字符缓冲输出流对象
        6:遍历集合，得到每一个学生对象
        7:把学生对象的数据拼接成指定格式的字符串
        8:调用字符缓冲输出流对象的方法写数据
        9:释放资源
 */
public class ArrayListToFileDemo {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> al = new ArrayList<Student>();
        Student s1 = new Student(1001,"王杰",13,"山东");
        Student s2 = new Student(1002,"刘晶",14,"内蒙");
        Student s3 = new Student(1003,"万杰",16,"福建");
        Student s4 = new Student(1004,"王晶",24,"黑龙江");
        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\java4.txt"));
        for (Student s : al){
            StringBuilder sb = new StringBuilder();
            sb.append(s.getNum()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());
            String person = sb.toString();
            bw.write(person);
            bw.newLine();
        }

        bw.close();
    }
}
