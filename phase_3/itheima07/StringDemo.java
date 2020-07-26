package com.itheima07;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
    编码：
        byte[] getBytes()：使用平台的默认字符集将该 String编码为一系列字节，将结果存储到新的字节数组中
        byte[] getBytes(String charsetName)：使用指定的字符集将该 String编码为一系列字节，将结果存储到新的字节数组中

    解码：
        String(byte[] bytes)：通过使用平台的默认字符集解码指定的字节数组来构造新的 String
        String(byte[] bytes, String charsetName)：通过指定的字符集解码指定的字节数组来构造新的 String
 */
public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 定义一个字符串
        String s = "中国";

        //byte[] getBytes()：使用平台的默认字符集将该 String编码为一系列字节，将结果存储到新的字节数组中
        byte[] bytes = s.getBytes();// [-28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bytes));

        // byte[] getBytes(String charsetName)：使用指定的字符集将该 String编码为一系列字节，将结果存储到新的字节数组中
        byte[] bytes1 = s.getBytes("UTF-8");// [-28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bytes1));
        String s1 = new String(bytes1);
        System.out.println(s1);
        System.out.println("---------------");
        byte[] byres2 = s.getBytes("GBK");// [-42, -48, -71, -6]
        System.out.println(Arrays.toString(byres2));
        String gBk = new String(byres2, "GBk");
        System.out.println(gBk);


    }
}
