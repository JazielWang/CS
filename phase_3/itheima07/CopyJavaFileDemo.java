package com.itheima07;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 改进升级版，原始版本和字节流文件拷贝类似

public class CopyJavaFileDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\Google\\java.txt");
        FileWriter fw = new FileWriter("E:\\Google\\java3.txt");

        int len;
        char[] chs = new char[1024];
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs, 0, len);
        }

        fr.close();
        fw.close();
    }
}
