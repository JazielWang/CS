package com.itheima06;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Google\\java.txt");

        /*byte[] bys = new byte[5];
        // 第一次读取
        int len = fis.read(bys);
        System.out.println(len);
//        System.out.println(new String(bys));
        System.out.println(new String(bys,0,len));


        // 第二次读取
        len = fis.read(bys);
        System.out.println(len);
//        System.out.println(new String(bys));
        System.out.println(new String(bys,0,len));

        // 第三次读取
        len = fis.read(bys);
        System.out.println(len);
        System.out.println(new String(bys,0,len));

        len = fis.read(bys);
        System.out.println(len);
        len = fis.read(bys);
        System.out.println(len);*/

        int by;
        byte[] bys = new byte[1024];
        while ((by = fis.read(bys)) != -1) {
            System.out.println(new String(bys, 0, by));
        }

        fis.close();
    }
}
