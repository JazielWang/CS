package com.itheima06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyJpgDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Google\\OAE-151.jpg");
        FileOutputStream fos = new FileOutputStream("E:\\Google\\Dark\\OAR-151.jpg");

        byte[] bys = new byte[10240];
        int len;
        while ((len=fis.read(bys))!=-1){
            fos.write(bys);
        }

        fis.close();
        fos.close();
    }
}
