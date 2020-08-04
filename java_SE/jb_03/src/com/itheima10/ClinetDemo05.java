package com.itheima10;

import java.io.*;
import java.net.Socket;

public class ClinetDemo05 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.171.77.101", 10000);
        //封装文本文件的数据
        BufferedReader br = new BufferedReader(new FileReader("E:\\Google\\wxb.txt"));
        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //自定义结束标记
//        bw.write("886");
//        bw.newLine();
//        bw.flush();

        //public void shutdownOutput​()
        s.shutdownOutput();

        BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = br2.readLine();
        System.out.println("服务器的反馈：" + data);

        br.close();
        s.close();
    }
}
