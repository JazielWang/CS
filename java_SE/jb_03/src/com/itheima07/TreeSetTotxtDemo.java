package com.itheima07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

/*
    需求：键盘录入5个学生信息(姓名,语文成绩,数学成绩,英语成绩)。要求按照成绩总分从高到低写入文本文件
          格式：姓名,语文成绩,数学成绩,英语成绩	举例：林青霞,98,99,100

    思路：
        1:定义学生类
        2:创建TreeSet集合，通过比较器排序进行排序
        3:键盘录入学生数据
        4:创建学生对象，把键盘录入的数据对应赋值给学生对象的成员变量
        5:把学生对象添加到TreeSet集合
        6:创建字符缓冲输出流对象
        7:遍历集合，得到每一个学生对象
        8:把学生对象的数据拼接成指定格式的字符串
        9:调用字符缓冲输出流对象的方法写数据
        10:释放资源
 */
public class TreeSetTotxtDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\java4.txt"));
        TreeSet<Student2> ts = new TreeSet<Student2>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 s2, Student2 s1) {
                int num = (s1.getChinese() + s1.getMath() + s1.getEnglish()) - (s2.getMath() + s2.getEnglish() + s2.getChinese());
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });
        Student2 s1 = new Student2("王杰", 56, 89, 78);
        Student2 s2 = new Student2("刘晶", 78, 99, 85);
        Student2 s3 = new Student2("王敬", 79, 68, 45);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);

        for (Student2 s : ts) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName() + "," + s.getChinese() + "," + s.getEnglish() + "," + s.getMath());
            String s4 = sb.toString();
            bw.write(s4);
            bw.newLine();
        }
        bw.close();
    }
}
