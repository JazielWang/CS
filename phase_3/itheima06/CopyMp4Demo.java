package com.itheima06;

import java.io.*;
/*
    需求：
        把E:\\itcast\\字节流复制图片.avi 复制到模块目录下的 字节流复制图片.avi

    思路：
        1:根据数据源创建字节输入流对象
        2:根据目的地创建字节输出流对象
        3:读写数据，复制图片(一次读取一个字节数组，一次写入一个字节数组)
        4:释放资源

    四种方式实现复制视频，并记录每种方式复制视频的时间
        1:基本字节流一次读写一个字节             共耗时：64565毫秒
        2:基本字节流一次读写一个字节数组          共耗时：107毫秒
        3:字节缓冲流一次读写一个字节             共耗时：405毫秒
        4:字节缓冲流一次读写一个字节数组          共耗时：60毫秒
 */
public class CopyMp4Demo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\Google\\01.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\Google\\Dark\\s1e1.mp4"));

        byte[] bys = new byte[1024];
        int len;
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }

        bis.close();
        bos.close();

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
