package com.itheima07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
/*
    构造方法：
        OutputStreamWriter​(OutputStream out)：创建一个使用默认字符编码的OutputStreamWriter

    写数据的5种方式：
        void write​(int c)：写一个字符
        void write​(char[] cbuf)：写入一个字符数组
        void write​(char[] cbuf, int off, int len)：写入字符数组的一部分
        void write​(String str)：写一个字符串
        void write​(String str, int off, int len)：写一个字符串的一部分
 */
public class OutputStreamWriteDemo {
    public static void main(String[] args) throws IOException {

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\Google\\java.txt"));

        osw.write(98);

        char[] cha = {'a', 'b', 'd', 'r'};
        osw.write(cha);
        osw.write(cha, 1, cha.length-1);

        osw.write("qqqrrwef");
        osw.write("oyohoi", 0, 3);

        osw.close();
    }
}
