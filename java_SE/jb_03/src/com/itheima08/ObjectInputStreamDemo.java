package com.itheima08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
    构造方法：
        ObjectInputStream​(InputStream in)：创建从指定的InputStream读取的ObjectInputStream

    反序列化对象的方法：
        Object readObject​()：从ObjectInputStream读取一个对象
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\Google\\oos.txt"));

        Object o = ois.readObject();
        Student s = (Student) o;

        System.out.println(s.getName()+","+s.getAge());

        ois.close();
    }
}
