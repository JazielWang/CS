package com.itheima07;

import java.io.*;

public class CoversionSteamDemo {
    public static void main(String[] args) throws IOException {
//        OutputStreamWriter​(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter。
//        OutputStreamWriter​(OutputStream out, String charsetName) 创建一个使用命名字符集的OutputStreamWriter。
//        FileOutputStream fos = new FileOutputStream("myCharStream\\osw.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos);
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myCharStream\\osw.txt"));
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myCharStream\\osw.txt"),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\Google\\java.txt"),"GBK");
        osw.write("中国");
        osw.close();

//        InputStreamReader​(InputStream in) 创建一个使用默认字符集的InputStreamReader。
//        InputStreamReader​(InputStream in, String charsetName) 创建一个使用命名字符集的InputStreamReader。
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("myCharStream\\osw.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\Google\\java.txt"),"GBK");
        int by;
        while ((by = isr.read()) != -1){
            System.out.print((char)by);
        }
        isr.close();
    }
}
